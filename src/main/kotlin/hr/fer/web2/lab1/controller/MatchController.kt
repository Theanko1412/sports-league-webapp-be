package hr.fer.web2.lab1.controller

import hr.fer.web2.lab1.model.dao.LeagueDAO
import hr.fer.web2.lab1.model.dao.TeamDAO
import hr.fer.web2.lab1.model.dao.toDTO
import hr.fer.web2.lab1.model.dto.MatchDTO
import hr.fer.web2.lab1.model.dto.toDAO
import hr.fer.web2.lab1.service.LeagueService
import hr.fer.web2.lab1.service.MatchService
import hr.fer.web2.lab1.service.TeamService
import java.net.URI
import org.springframework.http.ResponseEntity
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/match", produces = ["application/json"])
class MatchController(
    private val matchService: MatchService,
    private val leagueService: LeagueService,
    private val teamService: TeamService,
) {

    @GetMapping("/{id}")
    fun getMatch(@PathVariable id: String): MatchDTO?{
        return matchService.getMatchById(id)?.toDTO()
    }

    @GetMapping
    fun getMatches(@RequestParam(required = false) filter: String? = null): List<MatchDTO>? {
        return when(filter) {
            null -> matchService.getAllMatches()?.map { it.toDTO() }
            else -> when(filter) {
                "homeTeam" -> matchService.getMatchesByHomeTeamId(filter)?.map { it.toDTO() }
                "awayTeam" -> matchService.getMatchesByAwayTeamId(filter)?.map { it.toDTO() }
                "league" -> matchService.getMatchesByLeagueId(filter)?.map { it.toDTO() }
                else -> throw IllegalArgumentException("Invalid filter")
            }
        }
    }
    @PostMapping
    fun addMatch(@RequestBody match: MatchDTO): ResponseEntity<MatchDTO> {
        val league = parseLeague(match)
        val matchDAO = match.toDAO(leagueService)
        matchDAO.league = league
        val savedMatch = matchService.addMatch(matchDAO)
        return ResponseEntity.created(URI.create("/match/${savedMatch.id}")).body(savedMatch.toDTO())
    }

    @PatchMapping("/{id}")
    fun updateMatch(@PathVariable id: String, @RequestBody match: MatchDTO, @AuthenticationPrincipal jwt: Jwt): MatchDTO {
        val existingMatch = matchService.getMatchById(id) ?: throw IllegalArgumentException("Match with id $id does not exist")
        if(jwt.subject != existingMatch.admin) throw AccessDeniedException("Only admin that created match can update it")

        //todo move to function
        var previousScoreHome = 0
        var previousScoreAway = 0

        if(existingMatch.homeTeamScore != null && existingMatch.awayTeamScore != null) {
            if(existingMatch.homeTeamScore!! > existingMatch.awayTeamScore!!) {
                previousScoreHome = 3
            } else if (existingMatch.homeTeamScore!! < existingMatch.awayTeamScore!!) {
                previousScoreAway = 3
            } else {
                previousScoreHome = 1
                previousScoreAway = 1
            }
        }


        val league = existingMatch.league
        val team1: TeamDAO? = league?.teams?.find { it.name == existingMatch.homeTeam }
        val team2: TeamDAO? = league?.teams?.find { it.name == existingMatch.awayTeam }

        if (match.homeTeamScore != null) {
            team1?.points = team1?.points?.minus(previousScoreHome)!!
            if(team1.points < 0) team1.points = 0
            existingMatch.homeTeamScore = match.homeTeamScore
        }
        if (match.awayTeamScore != null) {
            team2?.points = team2?.points?.minus(previousScoreAway)!!
            if(team2.points < 0) team2.points = 0
            existingMatch.awayTeamScore = match.awayTeamScore
        }

        if (team1 != null && team2 != null) {
            if (existingMatch.homeTeamScore!! > existingMatch.awayTeamScore!!) {
                team1.points += league.sport!!.winPoints
                team2.points += league.sport!!.losePoints
            } else if (existingMatch.homeTeamScore!! < existingMatch.awayTeamScore!!) {
                team1.points += league.sport!!.losePoints
                team2.points += league.sport!!.winPoints
            } else {
                team1.points += league.sport!!.drawPoints
                team2.points += league.sport!!.drawPoints
            }
        }

        val sortedTeams = league?.teams?.sortedByDescending { it.points }

        sortedTeams?.forEachIndexed { index, team ->
            team.position = index + 1
            teamService.updateTeam(team)
        }

        return matchService.updateMatch(existingMatch).toDTO()
    }


    @DeleteMapping("/{id}")
    fun deleteMatch(@PathVariable id: String, @AuthenticationPrincipal jwt: Jwt): MatchDTO? {
        val existingMatch = matchService.getMatchById(id) ?: throw IllegalArgumentException("Match with id $id does not exist")
        if(jwt.subject != existingMatch.admin) throw AccessDeniedException("Only admin that created match can update it")
        return matchService.deleteMatch(id)?.toDTO()
    }


    private fun parseLeague(match: MatchDTO): LeagueDAO? {
        require(!(match.leagueId == null && match.leagueName == null)) { "League id or name must be provided" }
        return if(match.leagueId != null) {
            leagueService.getLeagueById(match.leagueId)
        } else if(match.leagueName != null) {
            leagueService.getLeagueByName(match.leagueName)
        }
        else null
    }
}
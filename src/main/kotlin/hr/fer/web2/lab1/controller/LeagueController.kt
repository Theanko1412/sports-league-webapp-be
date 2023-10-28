package hr.fer.web2.lab1.controller

import hr.fer.web2.lab1.model.dao.SportDAO
import hr.fer.web2.lab1.model.dao.TeamDAO
import hr.fer.web2.lab1.model.dao.convertToTable
import hr.fer.web2.lab1.model.dao.toDTO
import hr.fer.web2.lab1.model.dto.LeagueDTO
import hr.fer.web2.lab1.model.dto.LeagueTableDTO
import hr.fer.web2.lab1.model.dto.toDAO
import hr.fer.web2.lab1.service.LeagueService
import hr.fer.web2.lab1.service.SportService
import hr.fer.web2.lab1.service.TeamService
import hr.fer.web2.lab1.utils.isUUID
import java.net.URI
import org.springframework.http.ResponseEntity
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
@RequestMapping("/league", produces = ["application/json"])
class LeagueController(
    private val leagueService: LeagueService,
    private val sportService: SportService,
    private val teamService: TeamService,
) {

    @GetMapping("/{id}")
    fun getLeague(@PathVariable id: String): LeagueDTO?{
        return if(isUUID(id)) {
            leagueService.getLeagueById(id)?.toDTO()
        } else {
            leagueService.getLeagueByName(id)?.toDTO()
        }
    }

    @GetMapping("/table/{id}")
    fun getLeagueTable(@PathVariable id: String): List<LeagueTableDTO>? {
        val league = if(isUUID(id)) {
            leagueService.getLeagueById(id)
        } else {
            leagueService.getLeagueByName(id)
        }

        val sortedTeams = league?.teams?.sortedByDescending { it.points }

        sortedTeams?.forEachIndexed { index, team ->
            team.position = index + 1
            teamService.updateTeam(team)
        }

        return league?.convertToTable()
    }

    @GetMapping
    fun getLeagues(@RequestParam(required = false) sport: String? = null): List<LeagueDTO>? {
        return when(sport) {
            null -> leagueService.getAllLeagues()?.map { it.toDTO() }
            else -> {
                if (isUUID(sport)) {
                    leagueService.getLeaguesBySportId(sport)?.map { it.toDTO() }
                } else {
                    leagueService.getLeaguesBySportName(sport)?.map { it.toDTO() }
                }
            }
        }
    }
    @PostMapping
    fun addLeague(@RequestBody league: LeagueDTO, @AuthenticationPrincipal jwt: Jwt): ResponseEntity<LeagueDTO> {
        require(jwt.subject != null) { "Admin id must be provided" }
        val sport = parseSport(league)
        val teams = parseTeams(league)
        val leagueDAO = league.toDAO()
        leagueDAO.admin = jwt.subject
        leagueDAO.sport = sport
        leagueDAO.teams = teams

        val savedLeague = leagueService.addLeague(leagueDAO)
        return ResponseEntity.created(URI.create("/league/${savedLeague.id}")).body(savedLeague.toDTO())
    }

    @PatchMapping("/{id}")
    fun updateLeague(@PathVariable id: String, @RequestBody league: LeagueDTO): LeagueDTO {
        require(id == league.id) { "Id in path and body must be the same" }
        return leagueService.updateLeague(league.toDAO()).toDTO()
    }

    @DeleteMapping("/{id}")
    fun deleteLeague(@PathVariable id: String): LeagueDTO? {
        return leagueService.deleteLeague(id)?.toDTO()
    }


    private fun parseSport(league: LeagueDTO): SportDAO? {
        require(!(league.sportId == null && league.sportName == null)) { "Sport id or name must be provided" }
        return if(league.sportId != null) {
            sportService.getSportById(league.sportId)
        } else {
            sportService.getSportByName(league.sportName!!)
        }
    }

    private fun parseTeams(league: LeagueDTO): List<TeamDAO>? {
        if(league.teams == null) return null
        for (team in league.teams) {
            require(!(team.id == null || team.name == null)) { "Team id or name must be provided" }
        }
        val teams = mutableListOf<TeamDAO>()
        for (team in league.teams) {
            if(team.id != null) {
                teamService.getTeamById(team.id)?.let { teams.add(it) }
            } else if(team.name != null) {
                teamService.getTeamByName(team.name)?.let { teams.add(it) }
            }
        }
        return teams
    }

}
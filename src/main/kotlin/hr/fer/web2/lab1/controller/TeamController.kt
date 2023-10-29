package hr.fer.web2.lab1.controller

import hr.fer.web2.lab1.model.dao.LeagueDAO
import hr.fer.web2.lab1.model.dao.PlayerDAO
import hr.fer.web2.lab1.model.dao.SportDAO
import hr.fer.web2.lab1.model.dao.TeamDAO
import hr.fer.web2.lab1.model.dao.toDTO
import hr.fer.web2.lab1.model.dto.TeamDTO
import hr.fer.web2.lab1.model.dto.toDAO
import hr.fer.web2.lab1.service.LeagueService
import hr.fer.web2.lab1.service.PlayerService
import hr.fer.web2.lab1.service.SportService
import hr.fer.web2.lab1.service.TeamService
import hr.fer.web2.lab1.utils.isUUID
import java.net.URI
import org.springframework.security.access.AccessDeniedException
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
@RequestMapping("/team", produces = ["application/json"])
class TeamController(
    private val teamService: TeamService,
    private val sportService: SportService,
    private val leagueService: LeagueService,
    private val playerService: PlayerService,
) {

    @GetMapping("/{id}")
    fun getTeam(@PathVariable id: String): TeamDTO? {
        return if(isUUID(id)) {
            teamService.getTeamById(id)?.toDTO()
        } else {
            teamService.getTeamByName(id)?.toDTO()
        }
    }

    @GetMapping
    fun getTeams(@RequestParam(required = false) filter: String? = null): List<TeamDTO>? {
        return if(filter == null) {
            teamService.getAllTeams().map(TeamDAO::toDTO)
        } else when(filter) {
            "sport" -> teamService.getTeamsBySportId(filter)?.map(TeamDAO::toDTO)
            "league" -> teamService.getTeamsByLeagueId(filter)?.map(TeamDAO::toDTO)
            else -> throw IllegalArgumentException("Invalid filter")
        }
    }

    @PostMapping
    fun addTeam(@RequestBody team: TeamDTO, @AuthenticationPrincipal jwt: Jwt): ResponseEntity<TeamDTO> {
        require(jwt.subject != null) { "Admin id must be provided" }
        val sport = parseSport(team)
        val league = parseLeague(team)
        val players = parsePlayers(team)
        val teamDAO = team.toDAO()
        teamDAO.sport = sport
        teamDAO.league = league
        teamDAO.players = players
        teamDAO.admin = jwt.subject
        val savedTeam = teamService.addTeam(teamDAO)
        return ResponseEntity.created(URI.create("/team/${savedTeam.id}")).body(savedTeam.toDTO())
    }

    @PatchMapping("/{id}")
    fun updateTeam(@PathVariable id: String, @RequestBody team: TeamDTO, @AuthenticationPrincipal jwt: Jwt): TeamDTO {
        if(jwt.subject != team.admin) throw AccessDeniedException("Only admin that created team can update it")
        return teamService.updateTeam(team.toDAO()).toDTO()
    }

    @DeleteMapping("/{id}")
    fun deleteTeam(@PathVariable id: String, @AuthenticationPrincipal jwt: Jwt): TeamDTO? {
        val existingTeam = teamService.getTeamById(id) ?: throw IllegalArgumentException("Team with id $id does not exist")
        if(jwt.subject != existingTeam.admin) throw AccessDeniedException("Only admin that created team can update it")
        return teamService.deleteTeam(id)?.toDTO()
    }

    private fun parseSport(team: TeamDTO): SportDAO? {
        require(!(team.sportId == null && team.sportName == null)) { "Sport id or name must be provided" }
        return if(team.sportId != null) {
            sportService.getSportById(team.sportId)
        } else {
            sportService.getSportByName(team.sportName!!)
        }
    }

    private fun parseLeague(team: TeamDTO): LeagueDAO? {
        require(!(team.leagueId == null && team.leagueName == null)) { "League id or name must be provided" }
        return if(team.leagueId != null) {
            leagueService.getLeagueById(team.leagueId)
        } else {
            leagueService.getLeagueByName(team.leagueName!!)
        }
    }

    private fun parsePlayers(team: TeamDTO): List<PlayerDAO>? {
        if(team.players == null) return null
        for (player in team.players) {
            require(player.id != null) { "Player id must be provided" }
        }
        val players = mutableListOf<PlayerDAO>()
        for(player in team.players) {
            playerService.getPlayerById(player.id!!)?.let { players.add(it) }
        }
        return players
    }

}
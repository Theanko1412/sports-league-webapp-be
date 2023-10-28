package hr.fer.web2.lab1.controller

import hr.fer.web2.lab1.model.dao.LeagueDAO
import hr.fer.web2.lab1.model.dao.SportDAO
import hr.fer.web2.lab1.model.dao.TeamDAO
import hr.fer.web2.lab1.model.dao.toDTO
import hr.fer.web2.lab1.model.dto.PlayerDTO
import hr.fer.web2.lab1.model.dto.toDAO
import hr.fer.web2.lab1.service.LeagueService
import hr.fer.web2.lab1.service.PlayerService
import hr.fer.web2.lab1.service.SportService
import hr.fer.web2.lab1.service.TeamService
import java.net.URI
import org.springframework.http.ResponseEntity
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
@RequestMapping("/player", produces = ["application/json"])
class PlayerController(
    private val playerService: PlayerService,
    private val sportService: SportService,
    private val teamService: TeamService,
    private val leagueService: LeagueService,
) {

    @GetMapping("/{id}")
    fun getPlayer(@PathVariable id: String): PlayerDTO? {
        return playerService.getPlayerById(id)?.toDTO()
    }

    @GetMapping
    fun getPlayers(@RequestParam(required = false) filter: String? = null): List<PlayerDTO>? {
        return if(filter == null) {
            playerService.getAllPlayers()?.map { it.toDTO() }
        } else when(filter) {
            "sport" -> playerService.getPlayersBySportId(filter)?.map { it.toDTO() }
            "league" -> playerService.getPlayersByLeagueId(filter)?.map { it.toDTO() }
            "name" -> playerService.getPlayersByName(filter)?.map { it.toDTO() }
            "surname" -> playerService.getPlayersBySurname(filter)?.map { it.toDTO() }
            else -> throw IllegalArgumentException("Invalid filter")
        }
    }

    @PostMapping
    fun addPlayer(@RequestBody player: PlayerDTO): ResponseEntity<PlayerDTO> {
        val sport = parseSport(player)
        val team = parseTeam(player)
        val league = parseLeague(player)
        val playerDAO = player.toDAO()
        playerDAO.sport = sport
        playerDAO.team = team
        playerDAO.league = league
        val savedPlayer = playerService.addPlayer(playerDAO)
        return ResponseEntity.created(URI.create("/player/${savedPlayer.id}")).body(savedPlayer.toDTO())
    }

    @PatchMapping("/{id}")
    fun updatePlayer(@PathVariable id: String, @RequestBody player: PlayerDTO): PlayerDTO {
        return playerService.updatePlayer(player.toDAO()).toDTO()
    }

    @DeleteMapping("/{id}")
    fun deletePlayer(@PathVariable id: String): PlayerDTO? {
        return playerService.deletePlayer(id)?.toDTO()
    }


    private fun parseSport(player: PlayerDTO): SportDAO? {
        return if (player.sportId != null) {
            sportService.getSportById(player.sportId)
        } else if (player.sportName != null) {
            sportService.getSportByName(player.sportName)
        } else {
            null
        }
    }

    private fun parseTeam(player: PlayerDTO): TeamDAO? {
        return if (player.teamId != null) {
            teamService.getTeamById(player.teamId)
        } else if (player.teamName != null) {
            teamService.getTeamByName(player.teamName)
        } else {
            null
        }
    }

    private fun parseLeague(player: PlayerDTO): LeagueDAO? {
        return if(player.leagueId != null) {
            leagueService.getLeagueById(player.leagueId)
        } else if(player.leagueName != null) {
            leagueService.getLeagueByName(player.leagueName)
        }
        else null
    }
}
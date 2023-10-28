package hr.fer.web2.lab1.controller

import hr.fer.web2.lab1.model.dao.LeagueDAO
import hr.fer.web2.lab1.model.dao.SportEnum
import hr.fer.web2.lab1.model.dao.toDTO
import hr.fer.web2.lab1.model.dto.SportDTO
import hr.fer.web2.lab1.model.dto.toDAO
import hr.fer.web2.lab1.service.LeagueService
import hr.fer.web2.lab1.service.SportService
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
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sport", produces = ["application/json"])
class SportController(
    private val sportService: SportService,
    private val leagueService: LeagueService,
) {

    @GetMapping("/{id}")
    fun getSport(@PathVariable id: String) : SportDTO? {
        return if (isUUID(id)) {
            sportService.getSportById(id)?.toDTO()
        } else {
            sportService.getSportByName(SportEnum.valueOf(id))?.toDTO()
        }
    }

    @GetMapping
    fun getSports() : List<SportDTO>? {
        return sportService.getAllSports().map { it.toDTO() }
    }

    @GetMapping("/enums")
    fun getSportsEnums() : List<SportEnum>? {
        return SportEnum.entries
    }

    @PostMapping
    fun addSport(@RequestBody sport: SportDTO, @AuthenticationPrincipal jwt: Jwt) : ResponseEntity<SportDTO> {
        require(jwt.subject != null) { "Admin id must be provided" }
        val leagues = parseLeagues(sport)
        val sportDAO = sport.toDAO()
        sportDAO.leagues = leagues
        sportDAO.admin = jwt.subject

        val savedSport = sportService.addSport(sportDAO)
        return ResponseEntity.created(URI("/sport/${savedSport.id}")).body(savedSport.toDTO())
    }

    @PatchMapping("/{id}")
    fun updateSport(@PathVariable id: String, @RequestBody sport: SportDTO) : SportDTO {
        require(id == sport.id) { "Id in path and body must be the same" }
        return sportService.updateSport(sport.toDAO()).toDTO()
    }

    @DeleteMapping("/{id}")
    fun deleteSport(@PathVariable id: String) : SportDTO? {
        return sportService.deleteSport(id)?.toDTO()
    }


    private fun parseLeagues(sport: SportDTO): List<LeagueDAO>? {
        if(sport.league == null) return null
        val leagues = mutableListOf<LeagueDAO>()
        for(league in sport.league) {
            if(league.id != null) {
                leagueService.getLeagueById(league.id)?.let { leagues.add(it) }
            } else {
                leagueService.getLeagueByName(league.name!!)?.let { leagues.add(it) }
            }
        }
        return leagues
    }
}
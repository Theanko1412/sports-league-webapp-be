package hr.fer.web2.lab1.controller

import hr.fer.web2.lab1.model.dao.LeagueDAO
import hr.fer.web2.lab1.model.dao.ScheduleDAO
import hr.fer.web2.lab1.model.dao.toDTO
import hr.fer.web2.lab1.model.dto.ScheduleDTO
import hr.fer.web2.lab1.model.dto.toDAO
import hr.fer.web2.lab1.service.LeagueService
import hr.fer.web2.lab1.service.MatchService
import hr.fer.web2.lab1.service.ScheduleService
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
@RequestMapping("/schedule", produces = ["application/json"])
class ScheduleController(
    private val scheduleService: ScheduleService,
    private val matchService: MatchService,
    private val leagueService: LeagueService,
) {

    @GetMapping("/{id}")
    fun getScheduleById(@PathVariable id: String): ScheduleDTO? {
        return scheduleService.getScheduleById(id)?.toDTO()
    }

    @GetMapping
    fun getAllSchedules(@RequestParam(required = false) filter: String? = null): List<ScheduleDTO>? {
        return if (filter == null) {
            scheduleService.getAllSchedules()?.map { it.toDTO() }
        } else when(filter) {
            "league" -> scheduleService.getSchedulesByLeagueId(filter)?.map { it.toDTO() }
            "match" -> scheduleService.getSchedulesByMatchId(filter)?.map { it.toDTO() }
            else -> throw IllegalArgumentException("Invalid filter")
        }
    }

    @PostMapping
    fun addSchedule(@RequestBody schedule: ScheduleDTO, @AuthenticationPrincipal jwt: Jwt): ResponseEntity<ScheduleDTO> {
        require(jwt.subject != null) { "Admin id must be provided" }
        val league = parseLeague(schedule)
        val scheduleDAO = schedule.toDAO()
        league.schedule = scheduleDAO
        scheduleDAO.league = league
        scheduleDAO.league!!.schedule = scheduleDAO
        scheduleDAO.admin = jwt.subject
        scheduleDAO.matches = scheduleService.generateMatches(scheduleDAO).matches
        val savedSchedule = scheduleService.addSchedule(scheduleDAO)
        return ResponseEntity.created(URI("/schedule/${savedSchedule.id}")).body(savedSchedule.toDTO())
    }

    @PatchMapping("/{id}")
    fun updateSchedule(@PathVariable id: String, @RequestBody schedule: ScheduleDAO, @AuthenticationPrincipal jwt: Jwt): ScheduleDTO {
        if(jwt.subject != schedule.admin) throw AccessDeniedException("Only admin that created schedule can update it")
        return scheduleService.updateSchedule(schedule).toDTO()
    }

    @DeleteMapping("/{id}")
    fun deleteSchedule(@PathVariable id: String, @AuthenticationPrincipal jwt: Jwt): ScheduleDTO? {
        val existingSchedule = scheduleService.getScheduleById(id) ?: throw IllegalArgumentException("Schedule with id $id does not exist")
        if(jwt.subject != existingSchedule.admin) throw AccessDeniedException("Only admin that created schedule can update it")
        val existingLeague = existingSchedule.league
        if(existingLeague != null) {
            existingLeague.schedule = null
            existingSchedule.league = null
            leagueService.updateLeague(existingLeague)
            scheduleService.updateSchedule(existingSchedule)
        }
        for(match in existingSchedule.matches!!) {
            matchService.deleteMatch(match.id!!)
        }
        return scheduleService.deleteSchedule(id)?.toDTO()
    }


    private fun parseLeague(schedule: ScheduleDTO): LeagueDAO {
        require(!(schedule.leagueId == null && schedule.leagueName == null)) { "League id or name must be provided" }
        return if (schedule.leagueId != null) {
            leagueService.getLeagueById(schedule.leagueId) ?: throw IllegalArgumentException("League with id ${schedule.leagueId} does not exist")
        } else {
            leagueService.getLeagueByName(schedule.leagueName!!) ?: throw IllegalArgumentException("League with name ${schedule.leagueName} does not exist")
        }
    }
}
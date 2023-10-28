package hr.fer.web2.lab1.service

import hr.fer.web2.lab1.model.dao.ScheduleDAO
import jakarta.transaction.Transactional

interface ScheduleService {

    fun generateMatches(schedule: ScheduleDAO): ScheduleDAO

    fun getAllSchedules(): List<ScheduleDAO>?
    fun getScheduleById(id: String): ScheduleDAO?
    fun getSchedulesByLeagueId(leagueId: String): List<ScheduleDAO>?
    fun getSchedulesByMatchId(matchId: String): List<ScheduleDAO>?

    fun addSchedule(schedule: ScheduleDAO): ScheduleDAO
    fun updateSchedule(schedule: ScheduleDAO): ScheduleDAO
    @Transactional
    fun deleteSchedule(id: String): ScheduleDAO?

}
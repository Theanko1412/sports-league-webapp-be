package hr.fer.web2.lab1.service.impl

import hr.fer.web2.lab1.model.dao.MatchDAO
import hr.fer.web2.lab1.model.dao.ScheduleDAO
import hr.fer.web2.lab1.repository.ScheduleRepository
import hr.fer.web2.lab1.service.ScheduleService
import jakarta.transaction.Transactional
import java.time.LocalDateTime
import org.springframework.stereotype.Service

@Service
class ScheduleServiceImpl(
    private val scheduleRepository: ScheduleRepository
) : ScheduleService {
    override fun generateMatches(schedule: ScheduleDAO): ScheduleDAO {
        val teams = schedule.league?.teams?.map { it.name!! } ?: return schedule
        val initialDate = LocalDateTime.now().plusDays(10L)
            .withHour(21)
            .withMinute(0)
            .withSecond(0)
            .withNano(0)
        val daysToAdd = 5L

        val roundRobinSchedule = roundRobinAlgorithm(teams)

        var currentDay = initialDate
        val matchDaos = mutableListOf<MatchDAO>()
        for (dayMatches in roundRobinSchedule) {
            for (match in dayMatches) {
                val matchDao = MatchDAO(
                    homeTeam = match.first,
                    awayTeam = match.second,
                    date = currentDay,
                    league = schedule.league,
                    admin = schedule.admin,
                    schedule = schedule,
                )
                matchDaos.add(matchDao)
            }
            currentDay = currentDay.plusDays(daysToAdd)
        }

        schedule.matches = matchDaos
        return schedule
    }

    override fun getAllSchedules(): List<ScheduleDAO>? {
        return scheduleRepository.findAll()
    }

    override fun getScheduleById(id: String): ScheduleDAO? {
        return scheduleRepository.findScheduleDAOById(id)
    }

    override fun getSchedulesByLeagueId(leagueId: String): List<ScheduleDAO>? {
        return scheduleRepository.findScheduleDAOSByLeagueId(leagueId)
    }

    override fun getSchedulesByMatchId(matchId: String): List<ScheduleDAO>? {
        return scheduleRepository.findScheduleDAOSByMatchesId(matchId)
    }

    override fun addSchedule(schedule: ScheduleDAO): ScheduleDAO {
        return scheduleRepository.save(schedule)
    }

    override fun updateSchedule(schedule: ScheduleDAO): ScheduleDAO {
        return scheduleRepository.save(schedule)
    }

    @Transactional
    override fun deleteSchedule(id: String): ScheduleDAO? {
        val schedule = scheduleRepository.findScheduleDAOById(id)
        scheduleRepository.delete(schedule)
        return schedule
    }


    fun roundRobinAlgorithm(teams: List<String>): List<List<Pair<String, String>>> {
        val n = teams.size
        val schedule = mutableListOf<List<Pair<String, String>>>()

        val currentTeams = teams.toMutableList()

        for (round in 0..<n - 1) {
            val matches = mutableListOf<Pair<String, String>>()
            for (i in 0..<n / 2) {
                val home = currentTeams[i]
                val away = currentTeams[n - 1 - i]
                matches.add(Pair(home, away))
            }
            schedule.add(matches)

            val last = currentTeams.removeAt(n - 1)
            currentTeams.add(1, last)
        }

        return schedule
    }


}
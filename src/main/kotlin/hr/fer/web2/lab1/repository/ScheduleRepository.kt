package hr.fer.web2.lab1.repository

import hr.fer.web2.lab1.model.dao.ScheduleDAO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface ScheduleRepository : JpaRepository<ScheduleDAO, String> {

    fun findScheduleDAOById(id: String): ScheduleDAO?
    fun findScheduleDAOSByLeagueId(leagueId: String): List<ScheduleDAO>?
    fun findScheduleDAOSByMatchesId(matchId: String): List<ScheduleDAO>?
}
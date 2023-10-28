package hr.fer.web2.lab1.repository

import hr.fer.web2.lab1.model.dao.MatchDAO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchRepository : JpaRepository<MatchDAO, String> {

    fun findMatchDAOById(id: String): MatchDAO?
    fun findMatchDAOSByHomeTeam(homeTeam: String): List<MatchDAO>?
    fun findMatchDAOSByAwayTeam(awayTeam: String): List<MatchDAO>?
    fun findMatchDAOSByLeagueId(leagueId: String): List<MatchDAO>?
}
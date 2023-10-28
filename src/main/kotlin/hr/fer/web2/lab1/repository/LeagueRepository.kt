package hr.fer.web2.lab1.repository

import hr.fer.web2.lab1.model.dao.LeagueDAO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LeagueRepository : JpaRepository<LeagueDAO, String> {

    fun findLeagueDAOById(id: String): LeagueDAO?
    fun findLeagueDAOByName(name: String): LeagueDAO?
    fun findLeagueDAOSBySportId(sportId: String): List<LeagueDAO>?
    fun findLeagueDAOSBySportName(sportName: String): List<LeagueDAO>?

}
package hr.fer.web2.lab1.repository

import hr.fer.web2.lab1.model.dao.PlayerDAO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface PlayerRepository : JpaRepository<PlayerDAO, String> {

    fun findPlayerDAOById(id: String): PlayerDAO?
    fun findPlayerDAOSByName(name: String): List<PlayerDAO>?

    fun findPlayerDAOSBySurname(surname: String): List<PlayerDAO>?
    fun findPlayerDAOSBySportId(sportId: String): List<PlayerDAO>?
    fun findPlayerDAOSByLeagueId(leagueId: String): List<PlayerDAO>?
}
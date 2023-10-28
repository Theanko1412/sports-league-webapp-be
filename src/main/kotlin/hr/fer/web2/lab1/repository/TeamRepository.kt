package hr.fer.web2.lab1.repository

import hr.fer.web2.lab1.model.dao.TeamDAO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface TeamRepository : JpaRepository<TeamDAO, String> {

    fun findTeamDAOById(id: String): TeamDAO?
    fun findTeamDAOByName(name: String): TeamDAO?
    fun findTeamDAOSBySportId(sportId: String): List<TeamDAO>?
    fun findTeamDAOSByLeagueId(leagueId: String): List<TeamDAO>?
}
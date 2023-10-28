package hr.fer.web2.lab1.service.impl

import hr.fer.web2.lab1.model.dao.TeamDAO
import hr.fer.web2.lab1.repository.TeamRepository
import hr.fer.web2.lab1.service.TeamService
import org.springframework.stereotype.Service

@Service
class TeamServiceImpl(
    private val teamRepository: TeamRepository
) : TeamService {
    override fun getAllTeams(): List<TeamDAO> {
        return teamRepository.findAll()
    }

    override fun getTeamById(id: String): TeamDAO? {
        return teamRepository.findTeamDAOById(id)
    }

    override fun getTeamByName(name: String): TeamDAO? {
        return teamRepository.findTeamDAOByName(name)
    }

    override fun getTeamsBySportId(sportId: String): List<TeamDAO>? {
        return teamRepository.findTeamDAOSBySportId(sportId)
    }

    override fun getTeamsByLeagueId(leagueId: String): List<TeamDAO>? {
        return teamRepository.findTeamDAOSByLeagueId(leagueId)
    }

    override fun addTeam(team: TeamDAO): TeamDAO {
        return teamRepository.save(team)
    }

    override fun updateTeam(team: TeamDAO): TeamDAO {
        return teamRepository.save(team)
    }

    override fun deleteTeam(id: String): TeamDAO? {
        val team = teamRepository.findTeamDAOById(id)
        teamRepository.delete(team)
        return team
    }
}
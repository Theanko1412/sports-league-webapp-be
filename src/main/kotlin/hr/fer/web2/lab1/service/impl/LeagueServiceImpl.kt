package hr.fer.web2.lab1.service.impl

import hr.fer.web2.lab1.model.dao.LeagueDAO
import hr.fer.web2.lab1.model.dao.TeamDAO
import hr.fer.web2.lab1.repository.LeagueRepository
import hr.fer.web2.lab1.service.LeagueService
import hr.fer.web2.lab1.service.TeamService
import org.springframework.stereotype.Service

@Service
class LeagueServiceImpl(
    private val leagueRepository: LeagueRepository,
    private val teamService: TeamService,
) : LeagueService {


    override fun getLeagueById(id: String): LeagueDAO? {
        return leagueRepository.findLeagueDAOById(id)
    }

    override fun getLeagueByName(name: String): LeagueDAO? {
        return leagueRepository.findLeagueDAOByName(name)
    }

    override fun getLeaguesBySportId(sportId: String): List<LeagueDAO>? {
        return leagueRepository.findLeagueDAOSBySportId(sportId)
    }

    override fun getLeaguesBySportName(sportName: String): List<LeagueDAO>? {
        return leagueRepository.findLeagueDAOSBySportName(sportName)
    }

    override fun getAllLeagues(): List<LeagueDAO>? {
        return leagueRepository.findAll()
    }

    override fun addLeague(league: LeagueDAO): LeagueDAO {
        return leagueRepository.save(league)
    }

    override fun updateLeague(league: LeagueDAO): LeagueDAO {
        return leagueRepository.save(league)
    }

    override fun deleteLeague(id: String): LeagueDAO? {
        val league = leagueRepository.findLeagueDAOById(id)
        leagueRepository.delete(league)
        return league
    }

    override fun addTeamToLeague(leagueId: String, teamId: String): LeagueDAO {
        val league = leagueRepository.findLeagueDAOById(leagueId)
            ?: throw IllegalArgumentException("League not found")

        val team = teamService.getTeamById(teamId)
            ?: throw IllegalArgumentException("Team not found")

        val teams = league.teams as MutableList<TeamDAO>
        teams.add(team)
        team.league = league

        return leagueRepository.save(league)
    }

}
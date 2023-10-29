package hr.fer.web2.lab1.service.impl

import hr.fer.web2.lab1.model.dao.MatchDAO
import hr.fer.web2.lab1.repository.MatchRepository
import hr.fer.web2.lab1.service.MatchService
import hr.fer.web2.lab1.service.TeamService
import org.springframework.stereotype.Service

@Service
class MatchServiceImpl(
    private val matchRepository: MatchRepository,
    private val teamService: TeamService,
) : MatchService {
    override fun getAllMatches(): List<MatchDAO>? {
        return matchRepository.findAll()
    }

    override fun getMatchById(id: String): MatchDAO? {
        return matchRepository.findMatchDAOById(id)
    }

    override fun getMatchesByHomeTeamId(homeTeamId: String): List<MatchDAO>? {
        return matchRepository.findMatchDAOSByHomeTeam(homeTeamId)
    }

    override fun getMatchesByAwayTeamId(awayTeamId: String): List<MatchDAO>? {
        return matchRepository.findMatchDAOSByAwayTeam(awayTeamId)
    }

    override fun getMatchesByLeagueId(leagueId: String): List<MatchDAO>? {
        return matchRepository.findMatchDAOSByLeagueId(leagueId)
    }

    override fun addMatch(match: MatchDAO): MatchDAO {
        return matchRepository.save(match)
    }

    override fun updateMatch(match: MatchDAO): MatchDAO {
        return matchRepository.save(match)
    }

    override fun deleteMatch(id: String): MatchDAO? {
        val match = matchRepository.findMatchDAOById(id)?: return null
        if(match.homeTeamScore != null && match.awayTeamScore != null) {
            if(match.homeTeamScore!! > match.awayTeamScore!!) {
                val winner = teamService.getTeamByName(match.homeTeam!!)
                val loser = teamService.getTeamByName(match.awayTeam!!)
                winner?.points = winner?.points?.minus(match.league?.sport?.winPoints!!)!!
                loser?.points = loser?.points?.minus(match.league?.sport?.losePoints!!)!!
                teamService.updateTeam(winner)
                teamService.updateTeam(loser)
            } else if(match.homeTeamScore!! < match.awayTeamScore!!) {
                val winner = teamService.getTeamByName(match.awayTeam!!)
                val loser = teamService.getTeamByName(match.homeTeam!!)
                winner?.points = winner?.points?.minus(match.league?.sport?.winPoints!!)!!
                loser?.points = loser?.points?.minus(match.league?.sport?.losePoints!!)!!
                teamService.updateTeam(winner)
                teamService.updateTeam(loser)
            } else {
                val homeTeam = teamService.getTeamByName(match.homeTeam!!)
                val awayTeam = teamService.getTeamByName(match.awayTeam!!)
                homeTeam?.points = homeTeam?.points?.minus(match.league?.sport?.drawPoints!!)!!
                awayTeam?.points = awayTeam?.points?.minus(match.league?.sport?.drawPoints!!)!!
                teamService.updateTeam(homeTeam)
                teamService.updateTeam(awayTeam)
            }

            val sortedTeams = match.league?.teams?.sortedByDescending { it.points }

            sortedTeams?.forEachIndexed { index, team ->
                team.position = index + 1
                teamService.updateTeam(team)
            }
        }

        matchRepository.delete(match)
        return match
    }
}
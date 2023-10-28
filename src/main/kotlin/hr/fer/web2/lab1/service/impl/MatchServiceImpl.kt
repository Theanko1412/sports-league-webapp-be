package hr.fer.web2.lab1.service.impl

import hr.fer.web2.lab1.model.dao.MatchDAO
import hr.fer.web2.lab1.repository.MatchRepository
import hr.fer.web2.lab1.service.MatchService
import org.springframework.stereotype.Service

@Service
class MatchServiceImpl(
    private val matchRepository: MatchRepository
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
        val match = matchRepository.findMatchDAOById(id)
        matchRepository.delete(match)
        return match
    }
}
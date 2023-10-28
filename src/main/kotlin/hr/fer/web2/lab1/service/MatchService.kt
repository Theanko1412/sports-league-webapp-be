package hr.fer.web2.lab1.service

import hr.fer.web2.lab1.model.dao.MatchDAO

interface MatchService {

    fun getAllMatches(): List<MatchDAO>?
    fun getMatchById(id: String): MatchDAO?
    fun getMatchesByHomeTeamId(homeTeamId: String): List<MatchDAO>?
    fun getMatchesByAwayTeamId(awayTeamId: String): List<MatchDAO>?
    fun getMatchesByLeagueId(leagueId: String): List<MatchDAO>?

    fun addMatch(match: MatchDAO): MatchDAO
    fun updateMatch(match: MatchDAO): MatchDAO
    fun deleteMatch(id: String): MatchDAO?
}
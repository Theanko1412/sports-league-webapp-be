package hr.fer.web2.lab1.service

import hr.fer.web2.lab1.model.dao.LeagueDAO

interface LeagueService {

    fun getLeagueById(id: String): LeagueDAO?
    fun getLeagueByName(name: String): LeagueDAO?
    fun getLeaguesBySportId(sportId: String): List<LeagueDAO>?
    fun getLeaguesBySportName(sportName: String): List<LeagueDAO>?

    fun getAllLeagues(): List<LeagueDAO>?
    fun addLeague(league: LeagueDAO): LeagueDAO
    fun updateLeague(league: LeagueDAO): LeagueDAO
    fun deleteLeague(id: String): LeagueDAO?

    fun addTeamToLeague(leagueId: String, teamId: String): LeagueDAO
}
package hr.fer.web2.lab1.service

import hr.fer.web2.lab1.model.dao.TeamDAO

interface TeamService {

    fun getAllTeams(): List<TeamDAO>
    fun getTeamById(id: String): TeamDAO?
    fun getTeamByName(name: String): TeamDAO?
    fun getTeamsBySportId(sportId: String): List<TeamDAO>?
    fun getTeamsByLeagueId(leagueId: String): List<TeamDAO>?

    fun addTeam(team: TeamDAO): TeamDAO
    fun updateTeam(team: TeamDAO): TeamDAO
    fun deleteTeam(id: String): TeamDAO?

}
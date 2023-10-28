package hr.fer.web2.lab1.service

import hr.fer.web2.lab1.model.dao.PlayerDAO

interface PlayerService {

    fun getAllPlayers(): List<PlayerDAO>?
    fun getPlayerById(id: String): PlayerDAO?
    fun getPlayersByName(name: String): List<PlayerDAO>?

    fun getPlayersBySurname(surname: String): List<PlayerDAO>?
    fun getPlayersBySportId(sportId: String): List<PlayerDAO>?
    fun getPlayersByLeagueId(leagueId: String): List<PlayerDAO>?

    fun addPlayer(player: PlayerDAO): PlayerDAO
    fun updatePlayer(player: PlayerDAO): PlayerDAO
    fun deletePlayer(id: String): PlayerDAO?
}
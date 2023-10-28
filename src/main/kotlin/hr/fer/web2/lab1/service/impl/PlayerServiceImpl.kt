package hr.fer.web2.lab1.service.impl

import hr.fer.web2.lab1.model.dao.PlayerDAO
import hr.fer.web2.lab1.repository.PlayerRepository
import hr.fer.web2.lab1.service.PlayerService
import org.springframework.stereotype.Service

@Service
class PlayerServiceImpl(
    private val playerRepository: PlayerRepository
) : PlayerService {
    override fun getAllPlayers(): List<PlayerDAO>? {
        return playerRepository.findAll()
    }

    override fun getPlayerById(id: String): PlayerDAO? {
        return playerRepository.findPlayerDAOById(id)
    }

    override fun getPlayersByName(name: String): List<PlayerDAO>? {
        return playerRepository.findPlayerDAOSByName(name)
    }

    override fun getPlayersBySurname(surname: String): List<PlayerDAO>? {
        return playerRepository.findPlayerDAOSBySurname(surname)
    }

    override fun getPlayersBySportId(sportId: String): List<PlayerDAO>? {
        return playerRepository.findPlayerDAOSBySportId(sportId)
    }

    override fun getPlayersByLeagueId(leagueId: String): List<PlayerDAO>? {
        return playerRepository.findPlayerDAOSByLeagueId(leagueId)
    }

    override fun addPlayer(player: PlayerDAO): PlayerDAO {
        return playerRepository.save(player)
    }

    override fun updatePlayer(player: PlayerDAO): PlayerDAO {
        return playerRepository.save(player)
    }

    override fun deletePlayer(id: String): PlayerDAO? {
        val player = playerRepository.findPlayerDAOById(id)
        playerRepository.delete(player)
        return player
    }
}
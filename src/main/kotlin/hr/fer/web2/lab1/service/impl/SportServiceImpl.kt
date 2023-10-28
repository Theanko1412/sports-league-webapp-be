package hr.fer.web2.lab1.service.impl

import hr.fer.web2.lab1.model.dao.SportDAO
import hr.fer.web2.lab1.model.dao.SportEnum
import hr.fer.web2.lab1.repository.SportRepository
import hr.fer.web2.lab1.service.SportService
import org.springframework.stereotype.Service

@Service
class SportServiceImpl(
    private val sportRepository: SportRepository
) : SportService {
    override fun getAllSports(): List<SportDAO> {
        return sportRepository.findAll()
    }

    override fun getSportById(id: String): SportDAO? {
        return sportRepository.findSportDAOById(id)
    }

    override fun getSportByName(name: SportEnum): SportDAO? {
        return sportRepository.findSportDAOByName(name)
    }

    override fun addSport(sport: SportDAO): SportDAO {
        return sportRepository.save(sport)
    }


    override fun updateSport(sport: SportDAO): SportDAO {
        return sportRepository.save(sport)
    }

    override fun deleteSport(id: String): SportDAO? {
        val sport = sportRepository.findSportDAOById(id)
        sportRepository.delete(sport)
        return sport
    }

}
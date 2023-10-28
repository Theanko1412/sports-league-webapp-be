package hr.fer.web2.lab1.service

import hr.fer.web2.lab1.model.dao.SportDAO
import hr.fer.web2.lab1.model.dao.SportEnum

interface SportService {

    fun getAllSports(): List<SportDAO>
    fun getSportById(id: String): SportDAO?
    fun getSportByName(name: SportEnum): SportDAO?

    fun addSport(sport: SportDAO): SportDAO

    fun updateSport(sport: SportDAO): SportDAO

    fun deleteSport(id: String): SportDAO?
}
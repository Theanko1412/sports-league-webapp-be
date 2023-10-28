package hr.fer.web2.lab1.repository

import hr.fer.web2.lab1.model.dao.SportDAO
import hr.fer.web2.lab1.model.dao.SportEnum
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface SportRepository : JpaRepository<SportDAO, String> {

    fun findSportDAOById(id: String): SportDAO?
    fun findSportDAOByName(name: SportEnum): SportDAO?

}
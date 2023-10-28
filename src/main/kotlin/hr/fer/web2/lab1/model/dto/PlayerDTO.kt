package hr.fer.web2.lab1.model.dto

import hr.fer.web2.lab1.model.dao.LeagueDAO
import hr.fer.web2.lab1.model.dao.PlayerDAO
import hr.fer.web2.lab1.model.dao.SportDAO
import hr.fer.web2.lab1.model.dao.SportEnum
import hr.fer.web2.lab1.model.dao.TeamDAO

data class PlayerDTO(
    val id: String? = null,
    val name: String? = null,
    val surname: String? = null,
    val age: Int? = null,
    val height: Int? = null,
    val weight: Int? = null,
    val nationality: String? = null,
    val teamId: String? = null,
    val teamName: String? = null,
    val leagueId: String? = null,
    val leagueName: String? = null,
    val sportId: String? = null,
    val sportName: SportEnum? = null,
    val admin: String? = null,
)

fun PlayerDTO.toDAO(): PlayerDAO {
    return PlayerDAO(
        id = this.id,
        name = this.name,
        surname = this.surname,
        age = this.age,
        height = this.height,
        weight = this.weight,
        nationality = this.nationality,
        team = TeamDAO().apply {
            this.id = this@toDAO.teamId
            this.name = this@toDAO.teamName
        },
        league = LeagueDAO().apply {
            this.id = this@toDAO.leagueId
            this.name = this@toDAO.leagueName
        },
        sport = SportDAO().apply {
            this.id = this@toDAO.sportId
            this.name = this@toDAO.sportName
        },
        admin = this.admin,
    )
}

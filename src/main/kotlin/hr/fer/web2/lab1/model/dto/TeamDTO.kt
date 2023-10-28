package hr.fer.web2.lab1.model.dto

import hr.fer.web2.lab1.model.dao.LeagueDAO
import hr.fer.web2.lab1.model.dao.SportDAO
import hr.fer.web2.lab1.model.dao.SportEnum
import hr.fer.web2.lab1.model.dao.TeamDAO

data class TeamDTO(
    val id: String? = null,
    val name: String? = null,
    val leagueId: String? = null,
    val leagueName: String? = null,
    val sportId: String? = null,
    val sportName: SportEnum? = null,
    val players: List<PlayerDTO>? = emptyList(),
    val admin: String? = null,
    val position: Int? = null,
    val points: Int = 0,
)

fun TeamDTO.toDAO(): TeamDAO {
    return TeamDAO(
        id = this.id,
        name = this.name,
        league = LeagueDAO().apply {
            this.id = this@toDAO.leagueId
            this.name = this@toDAO.leagueName
        },
        sport = SportDAO().apply {
            this.id = this@toDAO.sportId
            this.name = this@toDAO.sportName
        },
        players = this.players?.map { it.toDAO() },
        admin = this.admin,
        position = this.position,
        points = this.points,
    )
}

package hr.fer.web2.lab1.model.dto

import hr.fer.web2.lab1.model.dao.SportDAO
import hr.fer.web2.lab1.model.dao.SportEnum

data class SportDTO(
    val id: String? = null,
    val name: SportEnum? = null,
    val league: List<LeagueDTO>? = emptyList(),
    val admin: String? = null,
    val winPoints: Int,
    val drawPoints: Int,
    val losePoints: Int,
)

fun SportDTO.toDAO(): SportDAO {
    return SportDAO(
        id = this.id,
        name = this.name,
        leagues = this.league?.map { it.toDAO() },
        admin = this.admin,
        winPoints = this.winPoints,
        drawPoints = this.drawPoints,
        losePoints = this.losePoints,
    )
}
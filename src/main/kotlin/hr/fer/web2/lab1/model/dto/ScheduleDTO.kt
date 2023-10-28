package hr.fer.web2.lab1.model.dto

import hr.fer.web2.lab1.model.dao.LeagueDAO
import hr.fer.web2.lab1.model.dao.ScheduleDAO

data class ScheduleDTO(
    val id: String? = null,
    val matches: List<MatchDTO>? = emptyList(),
    val leagueId: String? = null,
    val leagueName: String? = null,
    val admin: String? = null,
)

fun ScheduleDTO.toDAO(): ScheduleDAO {
    return ScheduleDAO(
        id = this.id,
        matches = this.matches?.map { it.toDAO() },
        league = LeagueDAO().apply {
            this.id = this@toDAO.leagueId
            this.name = this@toDAO.leagueName
        },
        admin = this.admin,
    )
}

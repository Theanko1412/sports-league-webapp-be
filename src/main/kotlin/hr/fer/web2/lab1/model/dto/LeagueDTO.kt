package hr.fer.web2.lab1.model.dto

import hr.fer.web2.lab1.model.dao.LeagueDAO
import hr.fer.web2.lab1.model.dao.SportDAO
import hr.fer.web2.lab1.model.dao.SportEnum


data class LeagueDTO(
    val id: String? = null,
    val name: String? = null,
    val sportId: String? = null,
    val sportName: SportEnum? = null,
    val teams: List<TeamDTO>? = emptyList(),
    val schedule: ScheduleDTO? = null,
    val admin: String? = null,
    val matches: List<MatchDTO>? = emptyList(),
)

fun LeagueDTO.toDAO(): LeagueDAO {
    return LeagueDAO(
        id = this.id,
        name = this.name,
        sport = SportDAO().apply {
            this.id = this@toDAO.sportId
            this.name = this@toDAO.sportName
        },
        teams = this.teams?.map { it.toDAO() },
        schedule = this.schedule?.toDAO(),
        admin = this.admin,
        matches = this.matches?.map { it.toDAO() },
    )
}
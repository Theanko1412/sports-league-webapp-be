package hr.fer.web2.lab1.model.dto

import hr.fer.web2.lab1.model.dao.LeagueDAO
import hr.fer.web2.lab1.model.dao.MatchDAO
import hr.fer.web2.lab1.service.LeagueService
import java.time.LocalDateTime

data class MatchDTO(
    val id: String? = null,
    val homeTeam: String? = null,
    val awayTeam: String? = null,
    val homeTeamScore: Int? = null,
    val awayTeamScore: Int? = null,
    val date: LocalDateTime? = null,
    val leagueId: String? = null,
    val leagueName: String? = null,
    val admin: String? = null,
    val scheduleId: String? = null,
)

fun MatchDTO.toDAO(leagueService: LeagueService? = null): MatchDAO {
    return MatchDAO(
        id = this.id,
        homeTeam = this.homeTeam,
        awayTeam = this.awayTeam,
        homeTeamScore = this.homeTeamScore,
        awayTeamScore = this.awayTeamScore,
        date = this.date,
        league = if(leagueService == null) {
            LeagueDAO(
                id = this.leagueId,
                name = this.leagueName,
            )
        } else {
               if(this.leagueId != null) {
                   leagueService.getLeagueById(this.leagueId)
               } else if(this.leagueName != null) {
                   leagueService.getLeagueByName(this.leagueName)
               } else {
                   null
               }
        },
        admin = this.admin,
    )
}

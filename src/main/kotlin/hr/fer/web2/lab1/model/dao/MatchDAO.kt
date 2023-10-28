package hr.fer.web2.lab1.model.dao

import hr.fer.web2.lab1.model.dto.MatchDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime
import lombok.Data


@Entity
@Data
@Table(name = "match")
class MatchDAO(

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.UUID)
    @get:Column(name = "match_id", nullable = false)
    open var  id: String? = null,

    @get:Column(name = "match_home_team", nullable = false)
    open var  homeTeam: String? = null,

    @get:Column(name = "match_away_team", nullable = false)
    open var  awayTeam: String? = null,

    @get:Column(name = "match_home_team_score")
    open var  homeTeamScore: Int? = null,

    @get:Column(name = "match_away_team_score")
    open var  awayTeamScore: Int? = null,

    @get:Column(name = "match_date")
    open var  date: LocalDateTime? = null,

    @get:ManyToOne(
        targetEntity = LeagueDAO::class,
        cascade = [jakarta.persistence.CascadeType.ALL],
    )
    @get:JoinColumn(name = "match_league", nullable = false)
    open var league: LeagueDAO? = null,

    @get:Column(name = "match_admin", nullable = false)
    open var admin: String? = null,

    @get:ManyToOne(fetch = FetchType.LAZY)
    @get:JoinColumn(name = "schedule_id")
    open var schedule: ScheduleDAO? = null,
)

fun MatchDAO.toDTO(): MatchDTO {
    return MatchDTO(
        id = this.id,
        homeTeam = this.homeTeam,
        awayTeam = this.awayTeam,
        homeTeamScore = this.homeTeamScore,
        awayTeamScore = this.awayTeamScore,
        date = this.date,
        leagueId = this.league?.id,
        leagueName = this.league?.name,
        admin = this.admin,
        scheduleId = this.schedule?.id,
    )
}

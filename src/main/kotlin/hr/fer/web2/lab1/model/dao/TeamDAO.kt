package hr.fer.web2.lab1.model.dao

import hr.fer.web2.lab1.model.dto.TeamDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import lombok.Data


@Entity
@Data
@Table(name = "team")
class TeamDAO(

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.UUID)
    @get:Column(name = "team_id", nullable = false)
    open var  id: String? = null,

    @get:Column(name = "team_name", nullable = false, unique = true)
    open var  name: String? = null,

    @get:ManyToOne
    @get:JoinColumn(name = "team_league", nullable = false)
    open var  league: LeagueDAO? = null,

    @get:ManyToOne
    @get:JoinColumn(name = "team_sport", nullable = false)
    open var  sport: SportDAO? = null,

    @get:OneToMany(
        targetEntity = PlayerDAO::class,
        cascade = [jakarta.persistence.CascadeType.ALL],
    )
    open var  players: List<PlayerDAO>? = emptyList(),

    @get:Column(name = "team_admin", nullable = false)
    open var admin: String? = null,

    @get:Column(name = "team_position")
    open var position: Int? = null,

    @get:Column(name = "team_points", nullable = false)
    open var points: Int = 0,
)

fun TeamDAO.toDTO(): TeamDTO {
    return TeamDTO(
        id = this.id,
        name = this.name,
        leagueId = this.league?.id,
        leagueName = this.league?.name,
        sportId = this.sport?.id,
        sportName = this.sport?.name,
        players = this.players?.map { it.toDTO() },
        admin = this.admin,
        position = this.position,
        points = this.points,
    )
}

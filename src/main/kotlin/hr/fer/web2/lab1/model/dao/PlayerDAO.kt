package hr.fer.web2.lab1.model.dao

import hr.fer.web2.lab1.model.dto.PlayerDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import lombok.Data


@Entity
@Data
@Table(name = "player")
class PlayerDAO(

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.UUID)
    @get:Column(name = "player_id", nullable = false)
    open var id: String? = null,

    @get:Column(name = "player_name", nullable = false)
    open var name: String? = null,

    @get:Column(name = "player_surname", nullable = false)
    open var surname: String? = null,

    @get:Column(name = "player_age", nullable = false)
    open var age: Int? = null,

    @get:Column(name = "player_height", nullable = false)
    open var height: Int? = null,

    @get:Column(name = "player_weight", nullable = false)
    open var weight: Int? = null,

    @get:Column(name = "player_nationality", nullable = false)
    open var nationality: String? = null,

    @get:ManyToOne
    @get:JoinColumn(name = "player_team", nullable = false)
    open var team: TeamDAO? = null,

    @get:ManyToOne
    @get:JoinColumn(name = "player_league", nullable = false)
    open var league: LeagueDAO? = null,

    @get:ManyToOne
    @get:JoinColumn(name = "player_sport", nullable = false)
    open var sport: SportDAO? = null,

    @get:Column(name = "player_admin", nullable = false)
    open var admin: String? = null,
)

fun PlayerDAO.toDTO(): PlayerDTO {
    return PlayerDTO(
        id = this.id,
        name = this.name,
        surname = this.surname,
        age = this.age,
        height = this.height,
        weight = this.weight,
        nationality = this.nationality,
        teamId = this.team?.id,
        teamName = this.team?.name,
        leagueId = this.league?.id,
        leagueName = this.league?.name,
        sportId = this.sport?.id,
        sportName = this.sport?.name,
        admin = this.admin,
    )
}

package hr.fer.web2.lab1.model.dao

import hr.fer.web2.lab1.model.dto.LeagueDTO
import hr.fer.web2.lab1.model.dto.LeagueTableDTO
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import lombok.Data


@Entity
@Data
@Table(name = "league")
class LeagueDAO(

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.UUID)
    @get:Column(name = "league_id", nullable = false)
    open var id: String? = null,

    @get:Column(name = "league_name", nullable = false, unique = true)
    open var name: String? = null,

    @get:ManyToOne(
        targetEntity = SportDAO::class,
        cascade = [CascadeType.PERSIST, CascadeType.MERGE],
    )
    @get:JoinColumn(name = "league_sport")
    open var sport: SportDAO? = null,

    @get:Column(name = "league_teams")
    @get:OneToMany(
        targetEntity = TeamDAO::class,
        cascade = [jakarta.persistence.CascadeType.ALL],
    )
    open var teams: List<TeamDAO>? = null,

    @get:OneToOne(
        targetEntity = ScheduleDAO::class,
        cascade = [jakarta.persistence.CascadeType.ALL],
    )
    @get:JoinColumn(name = "league_schedule")
    open var schedule: ScheduleDAO? = null,

    @get:Column(name = "league_admin", nullable = false)
    open var admin: String? = null,

    @get:OneToMany(
        mappedBy = "league",
        targetEntity = MatchDAO::class,
        cascade = [jakarta.persistence.CascadeType.ALL]
    )
    open var matches: List<MatchDAO>? = null,

    @get:OneToMany(mappedBy = "league", targetEntity = PlayerDAO::class, cascade = [jakarta.persistence.CascadeType.ALL])
    open var players: List<PlayerDAO>? = null

)

fun LeagueDAO.toDTO(): LeagueDTO {
    return LeagueDTO(
        id = this.id,
        name = this.name,
        sportId = this.sport?.id,
        sportName = this.sport?.name,
        teams = this.teams?.map { it.toDTO() },
        schedule = this.schedule?.toDTO(),
        admin = this.admin,
        matches = this.matches?.map { it.toDTO() },
    )
}

fun LeagueDAO.convertToTable(): List<LeagueTableDTO>? {
    return this.teams?.map {
        LeagueTableDTO(
            id = it.id,
            name = it.name,
            points = it.points,
            position = it.position,
        )
    }
}
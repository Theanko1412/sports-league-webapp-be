package hr.fer.web2.lab1.model.dao

import hr.fer.web2.lab1.model.dto.ScheduleDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import lombok.Data


@Entity
@Data
@Table(name = "schedule")
class ScheduleDAO(

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.UUID)
    @get:Column(name = "schedule_id", nullable = false)
    open var  id: String? = null,

    @get:Column(name = "schedule_matches", nullable = false)
    @get:OneToMany(
        targetEntity = MatchDAO::class,
        cascade = [jakarta.persistence.CascadeType.ALL],
        mappedBy = "schedule",
    )
    open var  matches: List<MatchDAO>? = null,

    @get:OneToOne(
        targetEntity = LeagueDAO::class,
        cascade = [jakarta.persistence.CascadeType.PERSIST, jakarta.persistence.CascadeType.MERGE],
    )
    @get:JoinColumn(name = "schedule_league", nullable = false)
    open var  league: LeagueDAO? = null,

    @get:Column(name = "schedule_admin", nullable = false)
    open var admin: String? = null,
)

fun ScheduleDAO.toDTO(): ScheduleDTO {
    return ScheduleDTO(
        id = this.id,
        matches = this.matches?.map { it.toDTO() },
        leagueId = this.league?.id,
        leagueName = this.league?.name,
        admin = this.admin,
    )
}
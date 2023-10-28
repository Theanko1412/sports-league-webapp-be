package hr.fer.web2.lab1.model.dao

import hr.fer.web2.lab1.model.dto.SportDTO
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany
import jakarta.persistence.PrePersist
import jakarta.persistence.Table
import lombok.Data

@Entity
@Data
@Table(name = "sport")
class SportDAO(

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.UUID)
    @get:Column(name = "sport_id", nullable = false)
    open var id: String? = null,

    @get:Enumerated(EnumType.STRING)
    @get:Column(name = "sport_name", nullable = false, unique = true)
    open var name: SportEnum? = null,

    @get:OneToMany(
        targetEntity = LeagueDAO::class,
        cascade = [CascadeType.ALL],
    )
    @JoinColumn(name = "sport_leagues")
    open var leagues: List<LeagueDAO>? = emptyList(),

    @get:Column(name = "sport_admin", nullable = false)
    open var admin: String? = null,

    @get:OneToMany(
        mappedBy = "sport",
        targetEntity = PlayerDAO::class,
        cascade = [CascadeType.ALL]
    )
    open var players: List<PlayerDAO>? = emptyList(),

    @get:Column(name = "sport_win_points", nullable = false) open var winPoints: Int = 0,

    @get:Column(name = "sport_draw_points", nullable = false) open var drawPoints: Int = 0,

    @get:Column(name = "sport_lose_points", nullable = false) open var losePoints: Int = 0,
    ) {
    @PrePersist
    fun prePersist() {

        when(name) {
            SportEnum.Football -> {
                winPoints = 3
                drawPoints = 1
                losePoints = 0
            }
            SportEnum.Basketball -> {
                winPoints = 2
                drawPoints = 1
                losePoints = 0
            }
            SportEnum.Baseball -> {
                winPoints = 2
                drawPoints = 1
                losePoints = 0
            }
            SportEnum.Rugby -> {
                winPoints = 4
                drawPoints = 2
                losePoints = 0
            }
            SportEnum.Cricket -> {
                winPoints = 2
                drawPoints = 1
                losePoints = 0
            }
            SportEnum.Hockey -> {
                winPoints = 3
                drawPoints = 1
                losePoints = 0
            }
            SportEnum.Volleyball -> {
                winPoints = 3
                drawPoints = 1
                losePoints = 0
            }
            SportEnum.Tennis -> {
                winPoints = 2
                drawPoints = 1
                losePoints = 0
            }
            SportEnum.Handball -> {
                winPoints = 2
                drawPoints = 1
                losePoints = 0
            }
            null -> {
                winPoints = 0
                drawPoints = 0
                losePoints = 0
            }
        }
    }
}

fun SportDAO.toDTO(): SportDTO {
    return SportDTO(
        id = this.id,
        name = this.name,
        league = this.leagues?.map { it.toDTO() },
        admin = this.admin,
        winPoints = this.winPoints,
        drawPoints = this.drawPoints,
        losePoints = this.losePoints,
    )
}

enum class SportEnum {
    Football,
    Basketball,
    Baseball,
    Rugby,
    Cricket,
    Hockey,
    Volleyball,
    Tennis,
    Handball,
}
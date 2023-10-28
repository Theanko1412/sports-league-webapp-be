package hr.fer.web2.lab1.config

import java.time.LocalDateTime

data class ApiError(
    val statusCode: Int,
    val statusMessage: String,
    val message: String,
    val path: String,
    val timestamp: LocalDateTime,
)
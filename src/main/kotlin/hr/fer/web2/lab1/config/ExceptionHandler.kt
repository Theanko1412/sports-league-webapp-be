package hr.fer.web2.lab1.config

import jakarta.servlet.http.HttpServletRequest
import java.time.LocalDateTime
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionControllerAdvice {

    @ExceptionHandler
    fun handleIllegalStateException(ex: Exception, request: HttpServletRequest): ResponseEntity<ApiError> {

        val path: String = request.contextPath + request.servletPath

        val error = ApiError(
            statusCode = 500,
            statusMessage = "Internal server error",
            message = ex.message ?: "Unknown error occurred",
            path = path,
            timestamp = LocalDateTime.now()
        )
        return ResponseEntity.status(500).body(error)
    }
}
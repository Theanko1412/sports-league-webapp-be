package hr.fer.web2.lab1.utils

import java.util.UUID

public fun isUUID(s: String): Boolean {
    return try {
        UUID.fromString(s)
        true
    } catch (ex: IllegalArgumentException) {
        false
    }
}
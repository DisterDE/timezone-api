package com.github.disterru.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.configureStatusPages() {
    install(StatusPages) {
        exception<TimezoneApiException> {
            call.respond(HttpStatusCode.NotFound)
        }
    }
}

sealed class TimezoneApiException : RuntimeException()
class CityNotFoundException : TimezoneApiException()
class ContinentNotFoundException : TimezoneApiException()
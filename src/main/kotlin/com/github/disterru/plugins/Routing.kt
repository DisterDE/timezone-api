package com.github.disterru.plugins

import com.github.disterru.services.TimezoneService
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val timezoneService by inject<TimezoneService>()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/timezone/{continent}/{city}") {
            val continent = call.parameters["continent"]
                ?: throw ContinentNotFoundException()
            val city = call.parameters["city"]
                ?: throw CityNotFoundException()

            val result = timezoneService.getTimezone(continent, city)
            call.respond(result)
        }
    }
}
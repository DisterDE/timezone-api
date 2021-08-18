package com.github.disterru.services

import com.github.disterru.models.TimeZone
import io.ktor.client.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class TimezoneService : KoinComponent {

    private val client by inject<HttpClient>()

    suspend fun getTimezone(continentName: String, cityName: String): TimeZone {
        return client.get("$URL/$continentName/$cityName")
    }

    companion object {
        const val URL = "https://worldtimeapi.org/api/timezone"
    }
}
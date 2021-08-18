package com.github.disterru.plugins

import com.github.disterru.services.TimezoneService
import io.ktor.application.*
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.koin.dsl.module
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    val beans = module {
        single { TimezoneService() }
        single {
            HttpClient {
                install(JsonFeature) {
                    serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                        prettyPrint = true
                    })
                }
                install(Logging) {
                    logger = Logger.DEFAULT
                    level = LogLevel.HEADERS
                }
            }
        }
    }

    install(Koin) {
        slf4jLogger()
        modules(beans)
    }
}
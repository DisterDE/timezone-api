package com.github.disterru

import com.github.disterru.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost") {
        configureRouting()
        configureMonitoring()
        configureSerialization()
        configureStatusPages()
        configureKoin()
    }.start(wait = true)
}

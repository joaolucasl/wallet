package com.github.joaolucasl.wallet_service

import com.github.joaolucasl.wallet_service.infrastructure.DatabaseConfig
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger
import org.slf4j.event.Level

fun main(args: Array<String>) {
    DatabaseConfig.setup()

    embeddedServer(Netty, 8080) {
        install(CallLogging) {
            level = Level.INFO
        }
        install(Koin) {
            slf4jLogger()
        }

        routing {
            get("/hello") {
                call.respondText("Hello")
            }
        }
    }.start(wait = true)
}
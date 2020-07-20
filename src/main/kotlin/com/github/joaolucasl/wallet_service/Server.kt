package com.github.joaolucasl.wallet_service

import com.github.joaolucasl.wallet_service.infrastructure.DatabaseConfig
import com.github.joaolucasl.wallet_service.infrastructure.modules.controllersModule
import com.github.joaolucasl.wallet_service.interfaces.persons
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.routing.Routing
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
            modules(controllersModule)
        }

        install(Routing) {
            persons()
        }
    }.start(wait = true)
}
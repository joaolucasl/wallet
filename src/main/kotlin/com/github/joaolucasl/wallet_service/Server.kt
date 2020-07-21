package com.github.joaolucasl.wallet_service

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.github.joaolucasl.wallet_service.infrastructure.DatabaseConfig
import com.github.joaolucasl.wallet_service.infrastructure.modules.controllersModule
import com.github.joaolucasl.wallet_service.infrastructure.modules.repositoriesModule
import com.github.joaolucasl.wallet_service.interfaces.persons
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
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

        install(ContentNegotiation) {
            jackson {
                registerModule(JodaModule())
                disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            }
        }

        install(Koin) {
            slf4jLogger()
            modules(controllersModule, repositoriesModule)
        }

        install(Routing) {
            persons()
        }
    }.start(wait = true)
}
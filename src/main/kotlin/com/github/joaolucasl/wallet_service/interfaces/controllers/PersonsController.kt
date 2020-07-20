package com.github.joaolucasl.wallet_service.interfaces.controllers

import io.ktor.application.ApplicationCall
import io.ktor.response.respondText

class PersonsController {
    suspend fun get(ctx: ApplicationCall) {
        ctx.respondText { "ALL" }
    }
}
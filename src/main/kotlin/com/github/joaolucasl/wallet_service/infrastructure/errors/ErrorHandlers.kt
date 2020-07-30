package com.github.joaolucasl.wallet_service.infrastructure.errors

import io.ktor.features.StatusPages
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import java.lang.Exception

fun StatusPages.Configuration.registerHandlers() {
    exception<Exception> { cause ->
        this.context.respond(HttpStatusCode.InternalServerError, CustomError(
                title = "GenericException",
                status = HttpStatusCode.InternalServerError.value,
                detail = cause.message ?: "No Message"
        ))
    }
}
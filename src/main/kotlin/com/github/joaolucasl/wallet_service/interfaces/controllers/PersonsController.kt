package com.github.joaolucasl.wallet_service.interfaces.controllers

import com.github.joaolucasl.wallet_service.domain.dto.PersonDTO
import com.github.joaolucasl.wallet_service.domain.dto.PersonsListDTO
import com.github.joaolucasl.wallet_service.domain.models.Person
import com.github.joaolucasl.wallet_service.domain.repositories.PersonsRepository
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.response.respondText
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.LoggerFactory

class PersonsController(val personsRepository: PersonsRepository) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    suspend fun get(ctx: ApplicationCall) {

        val persons = transaction {
            personsRepository.findAll()
        }
        ctx.respond(HttpStatusCode.OK, PersonsListDTO(items = persons))
    }

    suspend fun create(ctx: ApplicationCall) {
        val personPayload = ctx.receive<PersonDTO>()

        val persisted = personsRepository.create(personPayload)

        ctx.respond(HttpStatusCode.Created, persisted)
    }
}
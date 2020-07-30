package com.github.joaolucasl.wallet_service.interfaces.controllers

import com.github.joaolucasl.wallet_service.domain.dto.PersonDTO
import com.github.joaolucasl.wallet_service.domain.dto.PersonsListDTO
import com.github.joaolucasl.wallet_service.domain.services.PersonService
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import org.slf4j.LoggerFactory

class PersonsController(private val personService: PersonService) {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    suspend fun getAll(ctx: ApplicationCall) {

        val persons = personService.findAll()

        ctx.respond(HttpStatusCode.OK, PersonsListDTO(items = persons))
    }

    suspend fun get(ctx: ApplicationCall) {
        val id = ctx.parameters["id"]!!

        val person = personService.find(id)

        ctx.respond(HttpStatusCode.OK, person)
    }

    suspend fun create(ctx: ApplicationCall) {
        val personPayload = ctx.receive<PersonDTO>()

        val persisted = personService.create(personPayload)

        ctx.respond(HttpStatusCode.Created, persisted)
    }
}
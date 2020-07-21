package com.github.joaolucasl.wallet_service.interfaces.controllers

import com.github.joaolucasl.wallet_service.domain.dto.PersonsListDTO
import com.github.joaolucasl.wallet_service.domain.models.Person
import com.github.joaolucasl.wallet_service.domain.repositories.PersonsRepository
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import org.jetbrains.exposed.sql.transactions.transaction

class PersonsController(val personsRepository: PersonsRepository) {
    suspend fun get(ctx: ApplicationCall) {

        val persons = transaction {
            personsRepository.findAll()
        }
        ctx.respond(HttpStatusCode.OK, PersonsListDTO(items = persons))
    }
}
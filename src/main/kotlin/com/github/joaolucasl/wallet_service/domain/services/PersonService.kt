package com.github.joaolucasl.wallet_service.domain.services

import com.github.joaolucasl.wallet_service.domain.dto.PersonDTO
import com.github.joaolucasl.wallet_service.domain.dto.validatePersonDTO
import com.github.joaolucasl.wallet_service.domain.models.Person
import com.github.joaolucasl.wallet_service.domain.repositories.PersonsRepository
import com.github.joaolucasl.wallet_service.infrastructure.errors.CustomError
import io.ktor.http.HttpStatusCode
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class PersonService(val personsRepository: PersonsRepository) {
    fun findAll(): List<PersonDTO> = transaction {
        personsRepository.findAll()
    }

    fun find(uuid: String): PersonDTO {
        val person = transaction {
            Person.findById(UUID.fromString(uuid))
        } ?: throw CustomError(title = "Not Found", status = HttpStatusCode.NotFound.value, detail = "No Person found for ID $uuid")

        return person.toDTO()
    }

    fun create(personData: PersonDTO): PersonDTO {
        val validationResult = validatePersonDTO(personData)
        if(validationResult.errors.isNotEmpty()) {
           throw CustomError("Invalid Person Data", HttpStatusCode.BadRequest.value, validationResult.errors.toString())
        }
        return personsRepository.create(personData)
    }
}
package com.github.joaolucasl.wallet_service.infrastructure.persistence

import com.github.joaolucasl.wallet_service.domain.dto.PersonDTO
import com.github.joaolucasl.wallet_service.domain.models.Person
import com.github.joaolucasl.wallet_service.domain.repositories.Persons
import com.github.joaolucasl.wallet_service.domain.repositories.PersonsRepository
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.LoggerFactory
import java.util.*

class PersonsRepositoryImpl : PersonsRepository {
    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun findAll(): List<PersonDTO> {
        return Persons.selectAll().map {
            PersonDTO(
                id = it[Persons.id].value,
                legalName = it[Persons.legalName],
                displayName = it[Persons.displayName],
                motherName = it[Persons.motherName],
                birthDate = it[Persons.birthDate],
                registrationId = it[Persons.registrationId],
                createdAt = it[Persons.createdAt],
                updatedAt = it[Persons.updatedAt]
            )
        }
    }

    override fun create(person: PersonDTO) =
        transaction {
            val personId = Persons.insertAndGetId {
                it[legalName] = person.legalName
                it[displayName] = person.displayName
                it[motherName] = person.motherName
                it[birthDate] = person.birthDate
                it[registrationId] = person.registrationId
            }

            person.copy(id = personId.value)
        }
}
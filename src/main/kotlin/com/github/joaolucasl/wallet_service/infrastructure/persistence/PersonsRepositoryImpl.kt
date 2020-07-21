package com.github.joaolucasl.wallet_service.infrastructure.persistence

import com.github.joaolucasl.wallet_service.domain.models.Person
import com.github.joaolucasl.wallet_service.domain.repositories.Persons
import com.github.joaolucasl.wallet_service.domain.repositories.PersonsRepository
import org.jetbrains.exposed.sql.selectAll

class PersonsRepositoryImpl : PersonsRepository {
    override fun findAll(): List<Person> {
        return Persons.selectAll().map {
            Person(
                id = it[Persons.id],
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
}
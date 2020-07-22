package com.github.joaolucasl.wallet_service.domain.models

import com.github.joaolucasl.wallet_service.domain.repositories.Persons
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.EntityID
import org.joda.time.DateTime
import java.util.UUID

class Person(id: EntityID<UUID>) : Entity<UUID>(id) {
    companion object : EntityClass<UUID, Person>(Persons)

    var legalName by Persons.legalName
    val displayName by Persons.displayName
    val motherName by Persons.motherName
    val birthDate by Persons.birthDate
    val registrationId by Persons.registrationId
    val createdAt by Persons.createdAt
    val updatedAt by Persons.updatedAt
}
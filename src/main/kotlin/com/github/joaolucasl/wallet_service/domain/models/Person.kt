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
    var displayName by Persons.displayName
    var motherName by Persons.motherName
    var birthDate by Persons.birthDate
    var registrationId by Persons.registrationId
    var createdAt by Persons.createdAt
    var updatedAt by Persons.updatedAt
}
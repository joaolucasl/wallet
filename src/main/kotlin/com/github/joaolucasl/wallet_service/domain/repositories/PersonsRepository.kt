package com.github.joaolucasl.wallet_service.domain.repositories

import com.github.joaolucasl.wallet_service.domain.dto.PersonDTO
import com.github.joaolucasl.wallet_service.domain.models.Person
import org.jetbrains.exposed.dao.UUIDTable

object Persons : UUIDTable("persons") {
    val legalName = varchar("legalname", 100)
    val displayName = varchar("displayname", 100)
    val motherName = varchar("mothername", 100)
    val birthDate = date("birthdate")
    val registrationId = varchar("registrationid", 11)
    val createdAt = datetime("created_at")
    val updatedAt = datetime("updated_at")
}

interface PersonsRepository {
    fun findAll(): List<PersonDTO>
    fun create(person: PersonDTO): PersonDTO
}
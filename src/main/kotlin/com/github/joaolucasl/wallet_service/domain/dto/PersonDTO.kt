package com.github.joaolucasl.wallet_service.domain.dto

import org.joda.time.DateTime
import java.util.UUID

data class PersonDTO(
        val id: UUID?,
        val legalName: String,
        val displayName: String,
        val motherName: String,
        val birthDate: DateTime,
        val registrationId: String,
        val createdAt: DateTime?,
        val updatedAt: DateTime?
) {
    override fun toString(): String {
        return "Person(id=$id, legalName='$legalName', displayName='$displayName', motherName='$motherName', birthDate=$birthDate, registrationId='$registrationId', createdAt=$createdAt, updatedAt=$updatedAt)"
    }
}
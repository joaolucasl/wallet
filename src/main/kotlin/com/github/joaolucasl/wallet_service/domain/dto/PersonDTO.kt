package com.github.joaolucasl.wallet_service.domain.dto

import com.github.joaolucasl.wallet_service.domain.models.Person
import com.github.joaolucasl.wallet_service.util.validateCpf
import io.konform.validation.Validation
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

    companion object {
        fun from(person: Person): PersonDTO {
            return PersonDTO(
                id = person.id.value,
                legalName = person.legalName,
                displayName = person.displayName,
                motherName = person.motherName,
                birthDate = person.birthDate,
                registrationId = person.registrationId,
                createdAt = person.createdAt,
                updatedAt = person.updatedAt
            )
        }
    }
}

val validatePersonDTO = Validation<PersonDTO> {
    PersonDTO::birthDate {
        addConstraint("Invalid BirthDate") {
            it.isBeforeNow
        }
    }

    PersonDTO::registrationId {
        addConstraint("Invalid Registration ID") {
            validateCpf(it)
        }
    }
}
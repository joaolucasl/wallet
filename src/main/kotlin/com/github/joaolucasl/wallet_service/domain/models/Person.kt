package com.github.joaolucasl.wallet_service.domain.models

import org.joda.time.DateTime
import java.util.*

data class Person(
    val id: UUID,
    val legalName: String,
    val displayName: String,
    val motherName: String,
    val birthDate: DateTime,
    val registrationId: String,
    val createdAt: DateTime,
    val updatedAt: DateTime
)
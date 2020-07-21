package com.github.joaolucasl.wallet_service.domain.dto

import com.github.joaolucasl.wallet_service.domain.models.Person

data class PersonsListDTO(
    val items: List<Person>
)
package com.github.joaolucasl.wallet_service.infrastructure.modules


import com.github.joaolucasl.wallet_service.domain.services.PersonService

import org.koin.dsl.module

val servicesModule = module {
    single { PersonService(get()) }
}
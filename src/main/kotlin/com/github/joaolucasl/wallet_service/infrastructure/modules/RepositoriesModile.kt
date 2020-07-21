package com.github.joaolucasl.wallet_service.infrastructure.modules

import com.github.joaolucasl.wallet_service.domain.repositories.PersonsRepository
import com.github.joaolucasl.wallet_service.infrastructure.persistence.PersonsRepositoryImpl
import org.koin.dsl.module

val repositoriesModule = module {
    single<PersonsRepository> { PersonsRepositoryImpl() }
}
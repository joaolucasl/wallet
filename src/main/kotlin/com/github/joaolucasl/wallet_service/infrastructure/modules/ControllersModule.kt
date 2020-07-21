package com.github.joaolucasl.wallet_service.infrastructure.modules

import com.github.joaolucasl.wallet_service.interfaces.controllers.PersonsController
import org.koin.dsl.module

val controllersModule = module {
    single { PersonsController(get()) }
}


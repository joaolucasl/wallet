package com.github.joaolucasl.wallet_service.interfaces

import com.github.joaolucasl.wallet_service.interfaces.controllers.PersonsController
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import org.koin.ktor.ext.inject

fun Routing.persons() {
    val personsController by inject<PersonsController>()

    route("persons") {
        get { personsController.get(this.context) }
        post { personsController.create(this.context) }
    }
}
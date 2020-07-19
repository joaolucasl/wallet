package com.github.joaolucasl.wallet_service.infrastructure

import java.lang.System.getenv

object Environment {
    val DATABASE_HOST: String = getenv("DATABASE_HOST")
    val DATABASE_USER: String = getenv("DATABASE_USER")
    val DATABASE_PASSWORD: String = getenv("DATABASE_PASSWORD")
    val DATABASE_NAME: String = getenv("DATABASE_NAME")
}
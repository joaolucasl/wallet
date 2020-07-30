package com.github.joaolucasl.wallet_service.infrastructure.errors

import java.lang.Exception

data class CustomError(
    val title: String,
    val status: Int,
    val detail: String
) : Exception()
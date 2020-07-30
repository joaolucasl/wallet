package com.github.joaolucasl.wallet_service.infrastructure.errors

data class CustomError(
    val title: String,
    val status: Number,
    val detail: String
)
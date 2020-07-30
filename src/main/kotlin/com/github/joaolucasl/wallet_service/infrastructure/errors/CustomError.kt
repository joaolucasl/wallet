package com.github.joaolucasl.wallet_service.infrastructure.errors

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import java.lang.Exception

@JsonSerialize(using = CustomErrorSerializer::class)
data class CustomError(
    val title: String,
    val status: Int,
    val detail: String
) : Exception()

class CustomErrorSerializer : StdSerializer<CustomError>(CustomError::class.java) {
    override fun serialize(value: CustomError?, gen: JsonGenerator?, provider: SerializerProvider?) {
        gen.apply {
            this!!.writeStartObject()
            writeStringField("title", value!!.title)
            writeNumberField("status", value.status)
            writeStringField("detail", value.detail)
            writeEndObject()
        }
    }
}
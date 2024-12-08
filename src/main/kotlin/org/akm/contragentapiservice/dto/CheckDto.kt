package org.akm.contragentapiservice.dto

import com.fasterxml.jackson.databind.JsonNode

data class CheckDto(
    val inn: String,
    val data: JsonNode?,
    val type: String
)
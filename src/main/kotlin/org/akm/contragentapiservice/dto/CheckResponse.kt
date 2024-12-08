package org.akm.contragentapiservice.dto

import com.fasterxml.jackson.databind.JsonNode
import java.io.Serializable

data class CheckResponse(
    val inn: String,
    val violations: JsonNode,
    val data: JsonNode
) : Serializable
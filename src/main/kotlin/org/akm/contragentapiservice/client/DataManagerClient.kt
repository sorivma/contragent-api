package org.akm.contragentapiservice.client

import com.fasterxml.jackson.databind.JsonNode
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "dataManagerClient", url = "\${app.dataManager.url}")
interface DataManagerClient {
    @GetMapping(value = ["api/v1/data/organizations/{inn}"], produces = ["application/json"])
    fun getOrgByInn(@PathVariable("inn") inn: String): JsonNode
    @GetMapping(value = ["api/v1/data/persons/{inn}"], produces = ["application/json"])
    fun getPerByInn(@PathVariable("inn") inn: String): JsonNode
}
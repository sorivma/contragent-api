package org.akm.contragentapiservice.client

import com.fasterxml.jackson.databind.JsonNode
import org.akm.contragentapiservice.dto.CheckDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient("ruleEvaluationClient", url = "\${app.ruleEvaluation.url}")
interface RuleEvaluationClient {
    @PostMapping("/api/rules/evaluate")
    fun evaluateRules(@RequestBody checkDto: CheckDto): JsonNode
}
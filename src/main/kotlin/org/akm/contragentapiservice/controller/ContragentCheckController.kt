package org.akm.contragentapiservice.controller

import org.akm.contragentapiservice.dto.CheckRequest
import org.akm.contragentapiservice.dto.CheckResponse
import org.akm.contragentapiservice.service.ContragentCheckService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/check")
class ContragentCheckController(
    private val contragentCheckService: ContragentCheckService
) {
    @GetMapping
    fun check(@RequestBody checkRequest: CheckRequest): CheckResponse {
        return contragentCheckService.check(checkRequest)
    }
}
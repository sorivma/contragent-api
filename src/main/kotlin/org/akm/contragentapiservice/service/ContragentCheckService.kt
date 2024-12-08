package org.akm.contragentapiservice.service

import org.akm.contragentapiservice.dto.CheckRequest
import org.akm.contragentapiservice.dto.CheckResponse

interface ContragentCheckService {
    fun check(checkRequest: CheckRequest): CheckResponse
}
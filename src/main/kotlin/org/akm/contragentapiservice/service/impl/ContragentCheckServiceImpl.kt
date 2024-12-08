package org.akm.contragentapiservice.service.impl

import org.akm.contragentapiservice.client.DataManagerClient
import org.akm.contragentapiservice.client.RuleEvaluationClient
import org.akm.contragentapiservice.dto.CheckDto
import org.akm.contragentapiservice.dto.CheckRequest
import org.akm.contragentapiservice.dto.CheckResponse
import org.akm.contragentapiservice.service.ContragentCheckService
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class ContragentCheckServiceImpl(
    private val dataManagerClient: DataManagerClient,
    private val ruleEvaluationClient: RuleEvaluationClient
): ContragentCheckService {
    @Cacheable(value = ["check"], key = "#checkRequest")
    override fun check(checkRequest: CheckRequest): CheckResponse {
        val data = when(checkRequest.type) {
            CheckRequest.CheckType.ORG -> dataManagerClient.getOrgByInn(checkRequest.inn)
            CheckRequest.CheckType.PE -> dataManagerClient.getPerByInn(checkRequest.inn)
        }

        return CheckResponse(
            inn = checkRequest.inn,
            data = data,
            violations = ruleEvaluationClient.evaluateRules(
                CheckDto(
                    inn = checkRequest.inn,
                    data = data,
                    type = checkRequest.type.ruleType
                )
            )
        )
    }
}
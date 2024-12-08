package org.akm.contragentapiservice.dto

data class CheckRequest(
    val inn: String,
    val type: CheckType,
) {
    enum class CheckType(val ruleType: String) {
        ORG("ORGANIZATION_RULE"),
        PE("PERSON_RULE")
    }
}
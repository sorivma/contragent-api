package org.akm.contragentapiservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages = ["org"])
@EnableCaching
class ContragentApiServiceApplication

fun main(args: Array<String>) {
    runApplication<ContragentApiServiceApplication>(*args)
}

package me.choicore.api.authenticator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class AuthenticatorApplication

fun main(args: Array<String>) {
    runApplication<AuthenticatorApplication>(*args)
}

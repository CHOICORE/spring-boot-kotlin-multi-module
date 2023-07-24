package me.choicore.api.authenticator.presentation.web.rest.common

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import java.util.UUID.randomUUID


@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
class RequestLogger {
    private lateinit var uuid: String

    fun log(message: String) {
        println("[$uuid] $message")
    }

    @PostConstruct
    fun init() {
        uuid = randomUUID().toString()
    }

    @PreDestroy
    fun destroy() {

    }
}

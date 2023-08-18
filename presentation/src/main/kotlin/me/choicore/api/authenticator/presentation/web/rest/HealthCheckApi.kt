package me.choicore.api.authenticator.presentation.web.rest

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/api/v1/health")
class HealthCheckApi {

    @GetMapping("")
    fun healthCheck(): ResponseEntity<String> {
        return ResponseEntity.ok(null)
    }
}
package me.choicore.api.authenticator.infrastructure.persistence.jpa.model

import java.time.LocalDateTime


class UserEntity(
    val id: Long? = null,
    val nickname: String,
    val registeredAt: LocalDateTime,
    val modifiedAt: LocalDateTime? = null,
)

package me.choicore.api.authenticator.infrastructure.persistence.jpa.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime


@Entity
class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nickname: String,
    val registeredAt: LocalDateTime,
    val modifiedAt: LocalDateTime,
)

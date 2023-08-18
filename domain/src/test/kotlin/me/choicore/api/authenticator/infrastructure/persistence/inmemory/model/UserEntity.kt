package me.choicore.api.authenticator.infrastructure.persistence.inmemory.model

import me.choicore.api.authenticator.domain.user.model.DateOfBirth
import me.choicore.api.authenticator.domain.user.model.Gender
import me.choicore.api.authenticator.domain.user.model.Username
import me.choicore.api.authenticator.infrastructure.persistence.inmemory.Entity
import java.time.LocalDateTime

data class UserEntity(
    override val id: Long? = null,
    val email: String,
    val password: String,
    val nickname: String? = null,
    val username: Username,
    val gender: Gender,
    val phone: String? = null,
    val dateOfBirth: DateOfBirth,
    val registeredAt: LocalDateTime,
    val modifiedAt: LocalDateTime? = null,
    val lastLoggedInAt: LocalDateTime? = null,
) : Entity<Long>
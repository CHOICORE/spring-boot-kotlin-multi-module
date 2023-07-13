package me.choicore.api.authenticator.domain.user.model

import java.time.LocalDateTime

data class UserProfile(
    val id: Long,
    val nickname: String,
    val username: Username,
    val email: String?,
    val phone: String?,
    val gender: Gender,
    val dateOfBirth: DateOfBirth,
    val registeredAt: LocalDateTime,
)
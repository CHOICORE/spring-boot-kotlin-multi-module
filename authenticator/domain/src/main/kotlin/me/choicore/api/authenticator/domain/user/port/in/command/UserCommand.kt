package me.choicore.api.authenticator.domain.user.port.`in`.command

import me.choicore.api.authenticator.domain.user.model.Gender
import me.choicore.api.authenticator.domain.user.model.Username

sealed interface UserCommand {

    data class RegisterUser(
        val email: String,
        val password: String,
        val username: Username,
        val phone: String,
        val gender: Gender,
    )
}
package me.choicore.api.authenticator.domain.user.port.out

import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand

interface RegisterUserDrivenPort {

    fun register(registerUser: UserCommand.RegisterUser): UserProfile

}
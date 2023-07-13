package me.choicore.api.authenticator.domain.user.port.`in`.usecase

import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand

interface RegisterUserUseCase {

    fun register(registerUser: UserCommand.RegisterUser): UserProfile

}
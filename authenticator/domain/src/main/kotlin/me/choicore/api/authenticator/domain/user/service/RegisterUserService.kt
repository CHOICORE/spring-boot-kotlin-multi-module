package me.choicore.api.authenticator.domain.user.service

import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand
import me.choicore.api.authenticator.domain.user.port.`in`.usecase.RegisterUserUseCase
import me.choicore.api.authenticator.domain.user.port.out.RegisterUserDrivenPort


class RegisterUserService(
    private val registerUserDrivenPort: RegisterUserDrivenPort
) : RegisterUserUseCase {

    override fun register(registerUser: UserCommand.RegisterUser): UserProfile {
        return registerUserDrivenPort.register(registerUser)
    }
}
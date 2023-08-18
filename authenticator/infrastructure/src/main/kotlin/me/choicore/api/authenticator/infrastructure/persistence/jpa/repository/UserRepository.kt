package me.choicore.api.authenticator.infrastructure.persistence.jpa.repository

import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand
import me.choicore.api.authenticator.domain.user.port.out.RegisterUserDrivenPort

class UserRepository : RegisterUserDrivenPort {
    override fun register(registerUser: UserCommand.RegisterUser): Long {
        return 0L
    }
}
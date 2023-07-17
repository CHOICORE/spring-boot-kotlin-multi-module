package me.choicore.api.authenticator.domain.user.service

import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand
import me.choicore.api.authenticator.domain.user.port.`in`.usecase.UserUseCase
import me.choicore.api.authenticator.domain.user.port.out.RegisterUserDrivenPort


class UserService(
    private val registerUserDrivenPort: RegisterUserDrivenPort,
) : UserUseCase {

    override fun register(registerUser: UserCommand.RegisterUser): Long {
        return registerUserDrivenPort.register(registerUser)
    }

    override fun search(searchUser: UserCommand.SearchUser): List<UserProfile> {
        TODO("Not yet implemented")
    }

    override fun search(id: Long): UserProfile {
        TODO("Not yet implemented")
    }

    override fun modify(modifyUser: UserCommand.ModifyUser): UserProfile {
        TODO("Not yet implemented")
    }

    override fun delete(deleteUser: UserCommand.DeleteUser) {
        TODO("Not yet implemented")
    }

}

package me.choicore.api.authenticator.domain.user.service

import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand
import me.choicore.api.authenticator.domain.user.port.`in`.usecase.UserUseCase
import me.choicore.api.authenticator.domain.user.port.out.DeleteUserDrivenPort
import me.choicore.api.authenticator.domain.user.port.out.ModifyUserDrivenPort
import me.choicore.api.authenticator.domain.user.port.out.RegisterUserDrivenPort
import me.choicore.api.authenticator.domain.user.port.out.RetrieveUserDrivenPort

@Suppress("unused")
class UserService(
    private val registerUserDrivenPort: RegisterUserDrivenPort,
    private val retrieveUserDrivenPort: RetrieveUserDrivenPort,
    private val modifyUserDrivenPort: ModifyUserDrivenPort,
    private val deleteUserDrivenPort: DeleteUserDrivenPort,
) : UserUseCase {

    override fun register(registerUser: UserCommand.RegisterUser): Long {
        return registerUserDrivenPort.register(registerUser)
    }

    override fun searchAll(): List<UserProfile?> {
        return retrieveUserDrivenPort.findAll()
    }

    override fun search(searchUser: UserCommand.SearchUser): List<UserProfile> {
        TODO()
    }

    override fun search(id: Long): UserProfile {
        return retrieveUserDrivenPort.findById(id)
    }


    override fun modify(modifyUser: UserCommand.ModifyUser): UserProfile {
        return modifyUserDrivenPort.modifyUserProfile(
            id = modifyUser.id,
            nickname = modifyUser.nickname,
            gender = modifyUser.gender,
            username = modifyUser.username,
            phone = modifyUser.phone,
            dateOfBirth = modifyUser.dateOfBirth,
        )
    }


    override fun delete(deleteUser: UserCommand.DeleteUser) {
        deleteUserDrivenPort.deleteByIds(deleteUser.ids)
    }
}

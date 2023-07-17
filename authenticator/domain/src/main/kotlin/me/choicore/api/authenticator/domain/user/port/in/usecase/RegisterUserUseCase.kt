package me.choicore.api.authenticator.domain.user.port.`in`.usecase

import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand

interface UserUseCase {

    fun register(registerUser: UserCommand.RegisterUser): Long

    fun search(searchUser: UserCommand.SearchUser): List<UserProfile>

    fun search(id: Long): UserProfile

    fun modify(modifyUser: UserCommand.ModifyUser): UserProfile

    fun delete(deleteUser: UserCommand.DeleteUser)

}
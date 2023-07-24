package me.choicore.api.authenticator.infrastructure.persistence.jpa

import me.choicore.api.authenticator.domain.user.model.DateOfBirth
import me.choicore.api.authenticator.domain.user.model.Gender
import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.model.Username
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand
import me.choicore.api.authenticator.domain.user.port.out.DeleteUserDrivenPort
import me.choicore.api.authenticator.domain.user.port.out.ModifyUserDrivenPort
import me.choicore.api.authenticator.domain.user.port.out.RegisterUserDrivenPort
import me.choicore.api.authenticator.domain.user.port.out.RetrieveUserDrivenPort
import me.choicore.api.authenticator.infrastructure.persistence.jpa.repository.UserRepository

class UserJpaDrivenAdapter(
    private val userRepository: UserRepository,
) : RegisterUserDrivenPort, RetrieveUserDrivenPort, ModifyUserDrivenPort, DeleteUserDrivenPort {


    override fun register(registerUser: UserCommand.RegisterUser): Long {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<UserProfile?> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): UserProfile {
        TODO("Not yet implemented")
    }

    override fun modifyUserProfile(id: Long, nickname: String?, gender: Gender?, username: Username?, phone: String?, dateOfBirth: DateOfBirth?): UserProfile {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun deleteByIds(ids: List<Long>) {
        TODO("Not yet implemented")
    }
}
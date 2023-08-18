package me.choicore.api.authenticator.infrastructure.repository

import me.choicore.api.authenticator.domain.user.model.DateOfBirth
import me.choicore.api.authenticator.domain.user.model.Gender
import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.model.Username
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand
import me.choicore.api.authenticator.domain.user.port.out.RegisterUserDrivenPort
import me.choicore.api.authenticator.infrastructure.entity.UserEntity
import org.springframework.transaction.annotation.Transactional


@Transactional
class RegisterUserDrivenAdapter(
    private val userJpaRepository: UserJpaRepository,
) : RegisterUserDrivenPort {
    override fun register(registerUser: UserCommand.RegisterUser): UserProfile {
        val savedEntity: UserEntity = userJpaRepository.save(
            UserEntity(
                nickname = registerUser.username.toString(),
            ),
        )
        return savedEntity.domain()
    }

    private fun UserEntity.domain(): UserProfile {
        return UserProfile(
            id = this.id!!,
            nickname = this.nickname,
            registeredAt = this.registeredAt,
            gender = Gender.UNKNOWN,
            username = Username(
                firstName = "Jae-hyeong",
                lastName = "Choi",
            ),
            email = "choicore@github.com",
            phone = "010-1234-1234",
            dateOfBirth = DateOfBirth(
                year = 1993,
                month = 9,
                dayOfMonth = 22,
            ),
            lastLoggedInAt = this.modifiedAt,
        )
    }

}

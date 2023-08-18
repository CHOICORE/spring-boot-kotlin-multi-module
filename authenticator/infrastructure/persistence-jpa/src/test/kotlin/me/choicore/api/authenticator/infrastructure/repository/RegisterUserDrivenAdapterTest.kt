package me.choicore.api.authenticator.infrastructure.repository

import me.choicore.api.authenticator.domain.user.model.DateOfBirth
import me.choicore.api.authenticator.domain.user.model.Gender
import me.choicore.api.authenticator.domain.user.model.Username
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand
import me.choicore.api.authenticator.infrastructure.SpringBootDataJpaTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@SpringBootDataJpaTest
class RegisterUserDrivenAdapterTest @Autowired constructor(
    private val userJpaRepository: UserJpaRepository,
) {
    private val registerUserDrivenAdapter: RegisterUserDrivenAdapter by lazy {
        RegisterUserDrivenAdapter(userJpaRepository)
    }

    @Test
    fun `test register user`() {
        val (id, email, nickname, username, phone, gender, dateOfBirth, registeredAt, lastLoggedInAt) = registerUserDrivenAdapter.register(
            mockRegisterUserCommand(),
        )
        println(id)
        println(email)
        println(nickname)
        println(username)
        println(gender)
        println(dateOfBirth)
        println(phone)
        println(registeredAt)
        println(lastLoggedInAt)
    }
}

internal fun mockRegisterUserCommand(): UserCommand.RegisterUser {
    return UserCommand.RegisterUser(
        email = "choicore@github.com",
        password = "1q2w3e4r!",
        username = Username(
            firstName = "Choi",
            lastName = "Jae-Hyeong",
        ),
        gender = Gender.MALE,
        dateOfBirth = DateOfBirth(
            year = 1993,
            month = 9,
            dayOfMonth = 22,
        ),
    )
}
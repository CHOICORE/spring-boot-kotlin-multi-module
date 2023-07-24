package me.choicore.api.authenticator.domain.user.service

import me.choicore.api.authenticator.domain.user.mockRegisterUserCommand
import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.infrastructure.persistence.inmemory.UserInMemoryDrivenAdapter
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatNoException
import org.junit.jupiter.api.Test

class UserServiceTest {
    private val userInMemoryDrivenAdapter = UserInMemoryDrivenAdapter()
    private val userService: UserService = UserService(
        registerUserDrivenPort = userInMemoryDrivenAdapter,
        retrieveUserDrivenPort = userInMemoryDrivenAdapter,
        modifyUserDrivenPort = userInMemoryDrivenAdapter,
        deleteUserDrivenPort = userInMemoryDrivenAdapter,
    )

    @Test
    fun register() {

        // given
        val registerUser = mockRegisterUserCommand()

        // then
        assertThatNoException().isThrownBy {
            // when
            userService.register(registerUser = registerUser)
        }

    }

    @Test
    fun searchAll() {

        // given
        for (i in 1..10) {
            val registerUser = mockRegisterUserCommand().copy(
                email = "choicore$i@github.com"
            )
            userService.register(registerUser = registerUser)
        }

        // when
        val searchAll: List<UserProfile?> = userService.searchAll()

        // then
        assertThat(searchAll).size().isEqualTo(10)
    }
}
package me.choicore.api.authenticator.domain.user.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime


@Suppress("unused")
class UserProfileTest {

    @Test
    fun `test validate user profile`() {

        // given & when
        val registerAt = LocalDateTime.now()

        val userProfile = UserProfile(
            id = 1L,
            nickname = "choicore",
            username = Username(
                firstName = "Choi",
                lastName = "Jae-hyeong",
            ),
            email = "choicore@github.com",
            phone = "",
            gender = Gender.MALE,
            dateOfBirth = DateOfBirth(1993, 9, 22), registeredAt = registerAt,
        )

        val (
            id: Long,
            email: String,
            nickname: String?,
            username: Username,
            phone: String?,
            gender: Gender,
            dateOfBirth: DateOfBirth?,
            registeredAt: LocalDateTime,
        ) = userProfile
        assertThat(id).isEqualTo(1L)
        assertThat(nickname).isEqualTo("choicore")
        assertThat(username.firstName).isEqualTo("Choi")
        assertThat(username.lastName).isEqualTo("Jae-hyeong")
        assertThat(email).isEqualTo("choicore@github.com")
        assertThat(phone).isEqualTo("")
        assertThat(gender).isEqualTo(Gender.MALE)
        assertThat(dateOfBirth).isEqualTo(DateOfBirth(1993, 9, 22))
        assertThat(registeredAt).isEqualTo(registerAt)
    }
}

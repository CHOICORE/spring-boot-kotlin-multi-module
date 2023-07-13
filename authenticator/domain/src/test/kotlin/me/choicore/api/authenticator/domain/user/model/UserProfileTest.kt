package me.choicore.api.authenticator.domain.user.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class UserProfileTest {

    @Test
    fun `사용자 프로필 검증`() {

        // given & when
        val registerAt = LocalDateTime.now()
        val userProfile = UserProfile(
            id = 1L,
            nickname = "choicore",
            username = Username(
                firstName = "Choi",
                lastName = "Jae-hyeong",
            ),
            email = "",
            phone = "",
            Gender.MALE,
            DateOfBirth(1993, 9, 22),
            registerAt
        )

        val (id, nickname, username, email, phone, gender, dateOfBirth, registeredAt) = userProfile

        assertThat(id).isEqualTo(1L)
        assertThat(nickname).isEqualTo("choicore")
        assertThat(username.firstName).isEqualTo("Choi")
        assertThat(username.lastName).isEqualTo("Jae-hyeong")
        assertThat(email).isEqualTo("")
        assertThat(phone).isEqualTo("")
        assertThat(gender).isEqualTo(Gender.MALE)
        assertThat(dateOfBirth).isEqualTo(DateOfBirth(1993, 9, 22))
        assertThat(registeredAt).isEqualTo(registerAt)
    }

}

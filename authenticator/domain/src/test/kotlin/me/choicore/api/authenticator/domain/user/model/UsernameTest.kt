package me.choicore.api.authenticator.domain.user.model

import org.assertj.core.api.Assertions.assertThatNoException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class UsernameTest {

    @Test
    fun `test validate with blank first name`() {
        assertThatThrownBy {
            Username(
                firstName = "",
                lastName = "Choi",
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `test validate with blank last name`() {
        assertThatThrownBy {
            Username(
                firstName = "Jae-hyeong",
                lastName = "",
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `test validate with blank first and last name`() {
        assertThatThrownBy {
            Username(
                firstName = "",
                lastName = "",
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `test validate with non-blank first and last name`() {
        assertThatNoException().isThrownBy {
            Username(
                firstName = "Jae-hyeong",
                lastName = "Choi",
            )
        }
    }

}
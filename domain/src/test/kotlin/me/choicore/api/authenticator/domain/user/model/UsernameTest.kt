package me.choicore.api.authenticator.domain.user.model

import me.choicore.api.authenticator.domain.util.validate
import org.assertj.core.api.Assertions.assertThatNoException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class UsernameTest {

    @Test
    fun `test validate with blank first name`() {
        assertThatThrownBy {
            validate {
                Username(
                    firstName = "",
                    lastName = "Choi",
                )
            }
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `test validate with blank last name`() {
        assertThatThrownBy {
            validate {
                Username(
                    firstName = "Jae-hyeong",
                    lastName = "",
                )
            }
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `test validate with blank first and last name`() {
        assertThatThrownBy {
            validate {
                Username(
                    firstName = "",
                    lastName = "",
                )
            }
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `test validate with non-blank first and last name`() {
        assertThatNoException().isThrownBy {
            validate {
                Username(
                    firstName = "Jae-hyeong",
                    lastName = "Choi",
                )
            }
        }
    }

}
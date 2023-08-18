package me.choicore.api.authenticator.domain.user.model


import me.choicore.api.authenticator.domain.util.validate
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.time.DateTimeException


class DateOfBirthTest {

    @Test
    fun `test validate with create new instance`() {

        // given
        val year = 1993
        val month = 9
        val dayOfMonth = 22

        // when
        val dateOfBirth = DateOfBirth(year, month, dayOfMonth)

        // then
        assertThat(dateOfBirth.year).isEqualTo(year)
        assertThat(dateOfBirth.month).isEqualTo(month)
        assertThat(dateOfBirth.dayOfMonth).isEqualTo(dayOfMonth)
    }

    @Test
    fun `test validate with invalid date value`() {

        // given
        val year = 9999
        val month = 13
        val dayOfMonth = 13

        // then
        assertThatThrownBy {
            // when
            validate {
                DateOfBirth(year, month, dayOfMonth)
            }
        }
            .isInstanceOf(DateTimeException::class.java)
            .hasMessage("Invalid date of birth: ${year}-${month}-${dayOfMonth}")
    }
}

package me.choicore.api.authenticator.domain.user.model


import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.DateTimeException
import java.time.LocalDate

class DateOfBirthTest {
    @Test
    fun `생년월일 검증`() {

        // given
        val year = 1993
        val month = 9
        val dayOfMonth = 22

        // when
        val dateOfBirth1 = DateOfBirth(LocalDate.of(year, month, dayOfMonth))
        val dateOfBirth2 = DateOfBirth(year, month, dayOfMonth)

        // then
        // case 1: newInstance - LocalDate.of(year, month, dayOfMonth)
        assertThat(dateOfBirth1.year).isEqualTo(year)
        assertThat(dateOfBirth1.month).isEqualTo(month)
        assertThat(dateOfBirth1.dayOfMonth).isEqualTo(dayOfMonth)

        // case 2: newInstance - DateOfBirth(year, month, dayOfMonth)
        assertThat(dateOfBirth2.year).isEqualTo(year)
        assertThat(dateOfBirth2.month).isEqualTo(month)
        assertThat(dateOfBirth2.dayOfMonth).isEqualTo(dayOfMonth)

        // case 3: invalid date of birth throws IllegalArgumentException
        Assertions.assertThatThrownBy { DateOfBirth(1999, 13, 13) }
            .isInstanceOf(DateTimeException::class.java)
            .hasMessage("Invalid date of birth: 1999-13-13")

    }

}

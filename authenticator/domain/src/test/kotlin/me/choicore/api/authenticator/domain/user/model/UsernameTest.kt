package me.choicore.api.authenticator.domain.user.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class UsernameTest {

    @Test
    fun `test validate with blank first name`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Username(
                firstName = "",
                lastName = "Choi",
            )
        }
        assertEquals("First name must not be blank.", exception.message)
    }

    @Test
    fun `test validate with blank last name`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Username(
                firstName = "Jae-hyeong",
                lastName = "",
            )
        }
        assertEquals("Last name must not be blank.", exception.message)
    }

    @Test
    fun `test validate with blank first and last name`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Username(
                firstName = "",
                lastName = "",
            )
        }
        assertEquals("First name must not be blank.", exception.message)
    }

    @Test
    fun `test validate with non-blank first and last name`() {
        val username = Username(
            firstName = "Jae-hyeong",
            lastName = "Choi",
        )
        assertNotNull(username)
    }

    @Test
    fun `test validate with non-blank first and last name with spaces`() {
        val username = Username(
            firstName = "Jae-hyeong ",
            lastName = " Choi",
        )
        assertNotNull(username)
    }

    @Test
    fun `test validate with non-blank first and last name with spaces and tabs`() {
        val username = Username(
            firstName = "Jae-hyeong\t",
            lastName = "\tChoi",
        )
        assertNotNull(username)
    }

    @Test
    fun `test validate with non-blank first and last name with spaces and newlines`() {
        val username = Username(
            firstName = "Jae-hyeong\n",
            lastName = "\nChoi",
        )
        assertNotNull(username)
    }

    @Test
    fun `test validate with non-blank first and last name with spaces and carriage returns`() {
        val username = Username(
            firstName = "Jae-hyeong\r",
            lastName = "\rChoi",
        )
        assertNotNull(username)
    }

    @Test
    fun `test validate with non-blank first and last name with spaces and carriage returns and newlines`() {
        val username = Username(
            firstName = "Jae-hyeong\r\n",
            lastName = "\r\nChoi",
        )
        assertNotNull(username)
    }
}
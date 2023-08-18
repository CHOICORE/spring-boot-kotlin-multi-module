package me.choicore.api.authenticator.domain.user.model

import me.choicore.api.authenticator.domain.util.Validator
import me.choicore.api.authenticator.domain.util.extention.isEmailValid
import java.time.LocalDateTime

/**
 * User Profile Model.
 *
 * @property id User identifier number.
 * @property email User email.
 * @property nickname User nickname.
 * @property username User name.
 * @property phone User phone number.
 * @property gender User gender.
 * @property dateOfBirth User date of birth.
 * @property registeredAt User registered date.
 * @property lastLoggedInAt User last logged-in date time.
 */
data class UserProfile(
    val id: Long,
    val email: String,
    val nickname: String?,
    val username: Username,
    val phone: String? = null,
    val gender: Gender,
    val dateOfBirth: DateOfBirth? = null,
    val registeredAt: LocalDateTime,
    val lastLoggedInAt: LocalDateTime? = null,
) : Validator {

    @Throws(IllegalArgumentException::class)
    override fun validate() {
        // Validate email.
        this.email.isEmailValid()
    }
}
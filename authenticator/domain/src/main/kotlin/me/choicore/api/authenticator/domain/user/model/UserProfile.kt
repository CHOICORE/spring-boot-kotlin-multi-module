package me.choicore.api.authenticator.domain.user.model

import me.choicore.api.authenticator.domain.util.Validator
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
) : Validator() {
    init {
        validate()
    }


    @Throws(IllegalArgumentException::class)
    override fun validate() {
        // Validate email.
        require(isValidEmail()) { "Invalid email format: $email" }
    }
}


/**
 * Checks whether the email associated with this user profile is valid.
 *
 * An email is considered valid if it meets the following criteria:
 *  - It is not blank (i.e., not empty or containing only whitespace).
 *  - It follows the standard email format, which consists of a local part (before '@')
 *    and a domain part (after '@') connected with an '@' symbol, and a valid top-level domain (TLD).
 *  - The local part allows characters: A-Z, a-z, 0-9, '.', '_', '%', '+', and '-'.
 *  - The domain part allows characters: A-Z, a-z, 0-9, '.', and '-'.
 *  - The TLD allows only letters and must be at least 2 characters long.
 *
 * @return [Boolean] `true` if the email is valid, `false` otherwise.
 *
 * @throws IllegalArgumentException if the email is blank.
 */
@Throws(IllegalArgumentException::class)
private fun UserProfile.isValidEmail(): Boolean {
    require(email.isNotBlank()) { "Email must not be blank." }
    val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$")
    return email.matches(emailRegex)
}


package me.choicore.api.authenticator.domain.util.extention


/**
 * Checks whether the email associated with this user profile is Valid.
 *
 * An email is considered Valid if it meets the following criteria:
 * - It is not blank (i.e., not empty or containing only whitespace).
 * - It follows the standard email format, which consists of a local part (before '@')
 *   and a domain part (after '@') connected with an '@' symbol, and a Valid top-level domain (TLD).
 * - The local part allows characters: A-Z, a-z, 0-9, '.', '_', '%', '+', and '-'.
 * - The domain part allows characters: A-Z, a-z, 0-9, '.', and '-'.
 * - The TLD allows only letters and must be at least 2 characters long.
 *
 * @throws IllegalArgumentException if the email is blank or invalid.
 */
@Throws(IllegalArgumentException::class)
internal fun String.isEmailValid() {

    this.throwsIfBlank(errorMessage = "Email must not be blank.")

    require(Regex(pattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$").matches(input = this)) {
        "Email format is not Valid."
    }
}

/**
 * Validates the password to ensure it meets the required criteria.
 *
 * A Valid password must meet the following conditions:
 * 1. Must not be blank.
 * 2. Must be at least 8 characters long.
 * 3. Must contain at least one digit.
 * 4. Must contain at least one uppercase letter.
 * 5. Must contain at least one lowercase letter.
 * 6. Must contain at least one special character (non-alphanumeric).
 *
 * @throws IllegalArgumentException if the password does not meet the above criteria.
 */
@Throws(IllegalArgumentException::class)
internal fun String.isPasswordValid() {
    throwsIfBlank("Password must not be blank.")

    // 최소 비밀번호 길이 8
    check(this.length >= 8) {
        "Password must be at least 8 characters long."
    }

    // 최소 하나의 숫자를 가져야 함
    val containsNumber: Boolean = Regex("\\d").containsMatchIn(this)
    check(containsNumber) {
        "Password must contain at least one digit."
    }

    // 최소 하나의 대문자를 가져야 함
    val containsUpperCase: Boolean = Regex("[A-Z]").containsMatchIn(this)
    check(containsUpperCase) {
        "Password must contain at least one uppercase letter."
    }

    // 최소 하나의 소문자를 가져야 함
    val containsLowerCase: Boolean = Regex("[a-z]").containsMatchIn(this)
    check(containsLowerCase) {
        "Password must contain at least one lowercase letter."
    }

    // 최소 하나의 특수문자를 가져야 함
    val containsSpecialChar: Boolean = Regex("[^A-Za-z0-9]").containsMatchIn(this)
    check(containsSpecialChar) {
        "Password must contain at least one special character."
    }
}


/**
 * Throws an [IllegalArgumentException] if the receiving [String] is blank.
 *
 * A [String] is considered blank if it is empty or contains only whitespace characters.
 *
 * @param errorMessage The error message to be used in the thrown [IllegalArgumentException].
 *
 * @throws IllegalArgumentException if the receiving [String] is blank.
 */
@Throws(IllegalArgumentException::class)
internal fun String.throwsIfBlank(errorMessage: String) {
    require(this.isNotBlank()) { errorMessage }
}
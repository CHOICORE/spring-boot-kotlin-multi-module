package me.choicore.api.authenticator.domain.util


/**
 * Validator Interface.
 *
 * An abstract class that defines a validator interface for data validation.
 * Subclasses must implement the [validate] method to provide specific validation logic.
 */
abstract class Validator {

    /**
     * Validates the data based on specific rules defined by subclasses.
     * Subclasses must override this method to implement the validation logic.
     */
    @Throws(IllegalArgumentException::class)
    protected abstract fun validate()
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
internal fun String.validateEmail() {
    require(isNotBlank()) {
        "email must not be blank."
    }
    require(Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$").matches(this)) {
        "email format is not valid."
    }
}

//internal interface Validator {
//    fun validate()
//}
//
//internal inline fun <T : Validator> createModel(block: () -> T) {
//    block()
//        .apply { validate() }
//}
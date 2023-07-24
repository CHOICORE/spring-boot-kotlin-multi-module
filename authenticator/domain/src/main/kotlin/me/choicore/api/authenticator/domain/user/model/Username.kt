package me.choicore.api.authenticator.domain.user.model

import me.choicore.api.authenticator.domain.util.Validator

/**
 * Username Model.
 *
 * @property firstName The first name of the user.
 * @property lastName The last name of the user.
 */
data class Username(
    val firstName: String,
    val lastName: String,
) : Validator() {
    init {
        validate()
    }

    @Throws(IllegalArgumentException::class)
    override fun validate() {
        require(this.firstName.isNotBlank()) { "First name must not be blank." }
        require(this.lastName.isNotBlank()) { "Last name must not be blank." }
    }
}

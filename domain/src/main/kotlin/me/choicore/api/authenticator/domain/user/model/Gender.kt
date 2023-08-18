package me.choicore.api.authenticator.domain.user.model

/**
 * An enumeration representing genders.
 *
 * This enum class defines three gender types:
 * - [MALE]: Represents the male gender.
 * - [FEMALE]: Represents the female gender.
 * - [UNKNOWN]: Represents an unknown or unspecified gender.
 *
 * This enum can be used to represent the gender information of users.
 *
 * @property [MALE] Represents the male gender.
 * @property [FEMALE] Represents the female gender.
 * @property [UNKNOWN] Represents an unknown or unspecified gender.
 */
enum class Gender {
    /** Represents the male gender. */
    MALE,

    /** Represents the female gender. */
    FEMALE,

    /** Represents an unknown or unspecified gender. */
    UNKNOWN,
}

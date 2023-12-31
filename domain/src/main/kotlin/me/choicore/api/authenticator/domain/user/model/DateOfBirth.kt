package me.choicore.api.authenticator.domain.user.model

import me.choicore.api.authenticator.domain.util.Validator
import java.time.DateTimeException
import java.time.LocalDate

/**
 * Date of birth of a user.
 *
 * @property year The year of birth.
 * @property month The month of birth (1-12).
 * @property dayOfMonth The day of month of birth (1-31).
 */
data class DateOfBirth(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int,
) : Validator {

    /**
     * Validates the date of birth using the provided year, month, and day of month.
     *
     * This method checks if the combination of year, month, and day of month forms a Valid date.
     * If the date is invalid, it throws a [DateTimeException] with a specific error message.
     *
     * @throws DateTimeException if the combination of year, month, and day of month does not form a Valid date.
     */
    override fun validate() {
        try {
            LocalDate.of(this.year, this.month, this.dayOfMonth)
        } catch (e: DateTimeException) {
            throw DateTimeException("Invalid date of birth: ${this.year}-${this.month}-${this.dayOfMonth}")
        }
    }

}



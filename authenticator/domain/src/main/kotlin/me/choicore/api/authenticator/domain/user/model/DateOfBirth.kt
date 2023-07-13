package me.choicore.api.authenticator.domain.user.model

import me.choicore.api.authenticator.domain.Validator
import java.time.DateTimeException
import java.time.LocalDate

data class DateOfBirth(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int,
) : Validator() {
    init {
        validate()
    }

    constructor(dateOfBirth: LocalDate) : this(
        year = dateOfBirth.year,
        month = dateOfBirth.monthValue,
        dayOfMonth = dateOfBirth.dayOfMonth
    )

    override fun validate() {
        try {
            LocalDate.of(this.year, this.month, this.dayOfMonth)
        } catch (e: DateTimeException) {
            throw DateTimeException("Invalid Date of Birth: $year-$month-$dayOfMonth")
        }
    }
}

package me.choicore.api.authenticator.domain.user.model

import java.time.DateTimeException
import java.time.LocalDate

data class DateOfBirth(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int,
) {
    init {
        validateDateOfBirth(year, month, dayOfMonth)
    }

    constructor(dateOfBirth: LocalDate) : this(
        year = dateOfBirth.year,
        month = dateOfBirth.monthValue,
        dayOfMonth = dateOfBirth.dayOfMonth
    )

    private fun validateDateOfBirth(year: Int, month: Int, dayOfMonth: Int) {
        try {
            LocalDate.of(year, month, dayOfMonth)
        } catch (e: DateTimeException) {
            throw DateTimeException("Invalid date of birth: $year-$month-$dayOfMonth")
        }
    }

}
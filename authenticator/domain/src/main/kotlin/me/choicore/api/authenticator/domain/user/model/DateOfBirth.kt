package me.choicore.api.authenticator.domain.user.model

import java.time.LocalDate

data class DateOfBirth(
    val year: Int,
    val month: Int,
    val dayOfMonth: Int,
) {
    constructor(dateOfBirth: LocalDate) : this(
        year = dateOfBirth.year,
        month = dateOfBirth.monthValue,
        dayOfMonth = dateOfBirth.dayOfMonth
    )

}

package me.choicore.api.authenticator.domain.user

import me.choicore.api.authenticator.domain.user.model.DateOfBirth
import me.choicore.api.authenticator.domain.user.model.Gender
import me.choicore.api.authenticator.domain.user.model.Username
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand

internal fun mockRegisterUserCommand(): UserCommand.RegisterUser {
    return UserCommand.RegisterUser(
        email = "choicore@github.com",
        password = "1q2w3e4r!",
        username = Username(
            firstName = "Choi",
            lastName = "Jae-Hyeong",
        ),
        gender = Gender.MALE,
        dateOfBirth = DateOfBirth(
            year = 1993,
            month = 9,
            dayOfMonth = 22,
        ),
    )
}
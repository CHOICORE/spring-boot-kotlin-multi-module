package me.choicore.api.authenticator.domain.user.port.out

import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand

/**
 * The RegisterUserDrivenPort interface defines the user registration method.
 */
interface RegisterUserDrivenPort {

    /**
     * User Registration Method
     *
     * @param registerUser The [UserCommand.RegisterUser] object containing user registration information.
     * @return A [UserProfile] object representing the newly registered user.
     */
    fun register(registerUser: UserCommand.RegisterUser): UserProfile


}

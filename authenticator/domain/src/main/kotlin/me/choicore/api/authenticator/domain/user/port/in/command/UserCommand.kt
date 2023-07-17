package me.choicore.api.authenticator.domain.user.port.`in`.command

import me.choicore.api.authenticator.domain.Identifiable
import me.choicore.api.authenticator.domain.user.model.DateOfBirth
import me.choicore.api.authenticator.domain.user.model.Gender
import me.choicore.api.authenticator.domain.user.model.Username
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand.*

/**
 * User Management Request Command
 *
 * @see RegisterUser
 * @see SearchUser
 * @see ModifyUser
 * @see DeleteUser
 */
sealed interface UserCommand {
    sealed interface Create : UserCommand
    sealed interface Read : UserCommand, Identifiable<Long>
    sealed interface Update : UserCommand, Identifiable<Long>
    sealed interface Delete : UserCommand, Identifiable<Long>

    data class RegisterUser(
        val email: String,
        val password: String,
        val username: Username,
        val nickname: String,
        val gender: Gender,
        val dateOfBirth: DateOfBirth,
    ) : Create

    data class SearchUser(
        override val id: Long,
    ) : Read

    data class ModifyUser(
        override val id: Long,
    ) : Update

    data class DeleteUser(
        override val id: Long,
        val ids: List<Long>,
    ) : Delete
}
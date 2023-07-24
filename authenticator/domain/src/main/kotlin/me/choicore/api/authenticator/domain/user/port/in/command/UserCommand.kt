package me.choicore.api.authenticator.domain.user.port.`in`.command

import me.choicore.api.authenticator.domain.Identifiable
import me.choicore.api.authenticator.domain.user.model.DateOfBirth
import me.choicore.api.authenticator.domain.user.model.Gender
import me.choicore.api.authenticator.domain.user.model.Username
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand.*
import java.time.LocalDate

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
    sealed interface Delete : UserCommand

    data class RegisterUser(
        val email: String,
        val password: String,
        val username: Username,
        val gender: Gender,
        val dateOfBirth: DateOfBirth,
    ) : Create

    data class SearchUser(
        override val id: Long,
        val email: String?,
        val registeredAt: LocalDate?,
    ) : Read

    data class ModifyUser(
        override val id: Long,
        val nickname: String?,
        val username: Username?,
        val gender: Gender?,
        val phone: String?,
        val dateOfBirth: DateOfBirth?,
    ) : Update

    data class DeleteUser(
        val ids: List<Long>,
    ) : Delete
}
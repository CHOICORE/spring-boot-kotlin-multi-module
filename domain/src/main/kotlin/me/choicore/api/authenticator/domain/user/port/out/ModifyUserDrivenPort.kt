package me.choicore.api.authenticator.domain.user.port.out

import me.choicore.api.authenticator.domain.user.model.DateOfBirth
import me.choicore.api.authenticator.domain.user.model.Gender
import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.model.Username
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand

/**
 * The ModifyUserDrivenPort interface defines a method to modify user profiles.
 */
interface ModifyUserDrivenPort {

    /**
     * Modifies a user profile with the provided details.
     *
     * @param id The identifier number of the user profile to modify.
     * @param nickname The new nickname for the user profile. Pass null to keep the current value.
     * @param gender The new gender for the user profile. Pass null to keep the current value.
     * @param username The new username for the user profile. Pass null to keep the current value.
     * @param phone The new phone number for the user profile. Pass null to keep the current value.
     * @param dateOfBirth The new date of birth for the user profile. Pass null to keep the current value.
     * @return The modified [UserProfile] object with the updated details.
     *
     * @throws IllegalStateException if the specified user id is not found.
     *
     * @see UserProfile
     */
    fun modifyUserProfile(
        id: Long,
        nickname: String?,
        gender: Gender?,
        username: Username?,
        phone: String?,
        dateOfBirth: DateOfBirth?,
    ): UserProfile

    /**
     * Modifies a user profile with the provided details from the given [modifyUser] command object.
     *
     * The user profile with the specified id will be updated based on the values provided in the [modifyUser] command object.
     * Fields that are set to null in the [modifyUser] command will keep their current values in the user profile.
     *
     * @param modifyUser The command object containing the details to modify the user profile.
     * @return The modified [UserProfile] object with the updated details.
     *
     * @throws IllegalStateException if the [modifyUser] specified user id is not found.
     *
     * @see UserProfile
     * @see UserCommand.ModifyUser
     */
    fun modifyUserProfile(modifyUser: UserCommand.ModifyUser): UserProfile
}

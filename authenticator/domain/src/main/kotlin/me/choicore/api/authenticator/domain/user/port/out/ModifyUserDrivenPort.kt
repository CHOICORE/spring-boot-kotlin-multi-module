package me.choicore.api.authenticator.domain.user.port.out

import me.choicore.api.authenticator.domain.user.model.DateOfBirth
import me.choicore.api.authenticator.domain.user.model.Gender
import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.model.Username

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
     */
    fun modifyUserProfile(
        id: Long,
        nickname: String?,
        gender: Gender?,
        username: Username?,
        phone: String?,
        dateOfBirth: DateOfBirth?,
    ): UserProfile
}

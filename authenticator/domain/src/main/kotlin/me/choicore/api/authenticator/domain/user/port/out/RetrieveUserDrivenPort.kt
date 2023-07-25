package me.choicore.api.authenticator.domain.user.port.out

import me.choicore.api.authenticator.domain.user.model.UserProfile


/**
 * The InquiryUserDrivenPort interface defines the functionality to retrieve user profiles from the data source.
 */
interface RetrieveUserDrivenPort {

    /**
     * Retrieves Registered a list of UserProfiles from the data source.
     *
     * @return A [List] of [UserProfile] registered user profiles. An empty list is returned if there are no user profiles.
     *
     * @see UserProfile
     */
    fun findAll(): List<UserProfile>

    /**
     * Retrieves Registered a UserProfiles from the data source.
     *
     * @param id The identifier number of the user profile to find.
     * @return The [UserProfile] object corresponding to the given identifier number
     *
     * @throws IllegalStateException When the user profile corresponding to the given identifier number cannot be found.
     *
     * @see UserProfile
     */
    @Throws(IllegalStateException::class)
    fun findById(id: Long): UserProfile
}
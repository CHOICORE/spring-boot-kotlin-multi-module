package me.choicore.api.authenticator.domain.user.port.out

import me.choicore.api.authenticator.domain.user.model.UserProfile


/**
 * The InquiryUserDrivenPort interface defines the functionality to retrieve user profiles from the data source.
 */
interface RetrieveUserDrivenPort {

    /**
     * Retrieves Registered a list of UserProfiles from the data source.
     *
     * @return [List] of [UserProfile]
     */
    fun findAll(): List<UserProfile?>

    /**
     * Find the user profile by its identifier number.
     *
     * @param id The identifier number of the user profile to find.
     * @return The [UserProfile] object corresponding to the given identifier number, or null if not found.
     * @throws NoSuchElementException When the user profile corresponding to the given identifier number cannot be found.
     */
    @Throws(NoSuchElementException::class)
    fun findById(id: Long): UserProfile

}
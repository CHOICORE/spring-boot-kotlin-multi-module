package me.choicore.api.authenticator.domain.user.port.`in`.usecase

import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand

/**
 * The UserUseCase interface defines various user-related use cases.
 */
interface UserUseCase {

    /**
     * Registers a new user with the provided registration details.
     *
     * @param registerUser The [UserCommand.RegisterUser] object containing user registration information.
     * @return The identifier ([UserProfile.id]) of the newly registered user.
     */
    fun register(registerUser: UserCommand.RegisterUser): Long

    /**
     * Searches for user profiles that match the search criteria specified in the [UserCommand.SearchUser] object.
     *
     * @param searchUser The [UserCommand.SearchUser] object containing search criteria.
     * @return A list of [UserProfile] objects that match the search criteria. Returns an empty list if no matches are found.
     */
//    TODO: Uncomment this block to enable search function
//    fun search(searchUser: UserCommand.SearchUser): List<UserProfile>

    /**
     * Retrieves a list of all user profiles.
     *
     * @return A list of registered  [UserProfile] objects. Returns an empty list if no user profiles are available.
     */
    fun searchAll(): List<UserProfile>

    /**
     * Finds a user profile by the given identifier number.
     *
     * @param id The identifier number of the user profile to find.
     * @return The [UserProfile] object corresponding to the given identifier number.
     * @throws NoSuchElementException if the user profile with the given identifier number is not found.
     */
    fun search(id: Long): UserProfile

    /**
     * Modifies an existing user profile with the provided user modifications.
     *
     * @param modifyUser The [UserCommand.ModifyUser] object containing user modifications.
     * @return The updated [UserProfile] object after applying the modifications.
     */
    fun modify(modifyUser: UserCommand.ModifyUser): UserProfile

    /**
     * Deletes a user profile based on the information provided in the [UserCommand.DeleteUser] object.
     *
     * @param deleteUser The [UserCommand.DeleteUser] object containing information for user deletion.
     */
    fun delete(deleteUser: UserCommand.DeleteUser)
}

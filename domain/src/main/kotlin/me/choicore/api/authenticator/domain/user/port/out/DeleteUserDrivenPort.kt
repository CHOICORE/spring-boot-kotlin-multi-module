package me.choicore.api.authenticator.domain.user.port.out

/**
 * The DeleteUserDrivenPort interface defines methods to delete user profiles.
 */
interface DeleteUserDrivenPort {

    /**
     * Deletes a user profile by its identifier number.
     *
     * @param id The identifier number of the user profile to delete.
     */
    fun deleteById(id: Long)

    /**
     * Deletes user profiles specified by a list of identifier numbers.
     *
     * @param ids The list of identifier numbers of user profiles to delete.
     */
    fun deleteByIds(ids: List<Long>)
}

package me.choicore.api.authenticator.infrastructure.persistence.inmemory

import me.choicore.api.authenticator.domain.user.model.DateOfBirth
import me.choicore.api.authenticator.domain.user.model.Gender
import me.choicore.api.authenticator.domain.user.model.UserProfile
import me.choicore.api.authenticator.domain.user.model.Username
import me.choicore.api.authenticator.domain.user.port.`in`.command.UserCommand

import me.choicore.api.authenticator.domain.user.port.out.DeleteUserDrivenPort
import me.choicore.api.authenticator.domain.user.port.out.ModifyUserDrivenPort
import me.choicore.api.authenticator.domain.user.port.out.RegisterUserDrivenPort
import me.choicore.api.authenticator.domain.user.port.out.RetrieveUserDrivenPort
import me.choicore.api.authenticator.infrastructure.persistence.inmemory.model.UserEntity
import java.time.LocalDateTime


@Suppress("unused")
class UserInMemoryDrivenAdapter : RegisterUserDrivenPort, RetrieveUserDrivenPort, ModifyUserDrivenPort, DeleteUserDrivenPort {
    private val db: UserInMemoryDb = UserInMemoryDb()

    override fun register(registerUser: UserCommand.RegisterUser): Long {
        val userEntity = UserEntity(
            email = registerUser.email,
            password = registerUser.password,
            username = registerUser.username,
            gender = registerUser.gender,
            dateOfBirth = registerUser.dateOfBirth,
            registeredAt = LocalDateTime.now(), id = null, nickname = null, modifiedAt = null,
        )
        return db.save(userEntity)
    }

    @Throws(NoSuchElementException::class)
    override fun findById(id: Long): UserProfile {
        checkNotNull(db.findById(id)) { "Not Found User: $id" }.let { return it.domain() }
    }

    override fun findAll(): List<UserProfile?> {
        val userProfiles: List<UserEntity> = db.findAll()
        return userProfiles.domains()
    }

    @Throws(IllegalStateException::class)
    override fun modifyUserProfile(id: Long, nickname: String?, gender: Gender?, username: Username?, phone: String?, dateOfBirth: DateOfBirth?): UserProfile {
        val foundUserEntity: UserEntity = checkNotNull(db.findById(id = id)) { "Not Found User: $id" }

        val copiedUserEntity = foundUserEntity.copy(
            id = id,
            nickname = nickname ?: foundUserEntity.nickname,
            gender = gender ?: foundUserEntity.gender,
            username = username ?: foundUserEntity.username,
            phone = phone ?: foundUserEntity.phone,
            dateOfBirth = dateOfBirth ?: foundUserEntity.dateOfBirth,
            modifiedAt = LocalDateTime.now()
        )
        db.save(copiedUserEntity)
        return copiedUserEntity.domain()
    }

    @Throws(IllegalStateException::class)
    override fun deleteById(id: Long) {
        val deletedCount: Int = db.deleteById(id)
        isDeleted(deletedCount)
    }

    @Throws(IllegalStateException::class)
    override fun deleteByIds(ids: List<Long>) {
        val deletedCount = db.deleteByIds(ids)
        isDeleted(deletedCount)
    }

    private fun isDeleted(deletedCount: Int) {
        check(deletedCount < 1) {
            "Failed to delete user"
        }
    }
}

private fun UserEntity.domain(): UserProfile {
    return UserProfile(
        id = this.id!!,
        nickname = this.nickname,
        registeredAt = this.registeredAt,
        gender = Gender.UNKNOWN,
        username = Username(
            firstName = "Jae-hyeong",
            lastName = "Choi",
        ),
        email = "choicore@github.com",
        phone = "010-1234-1234",
        dateOfBirth = DateOfBirth(
            year = 1993,
            month = 9,
            dayOfMonth = 22
        ),
        lastLoggedInAt = this.lastLoggedInAt,
    )
}

private fun List<UserEntity>.domains(): List<UserProfile?> {
    return this.map { it.domain() }
}

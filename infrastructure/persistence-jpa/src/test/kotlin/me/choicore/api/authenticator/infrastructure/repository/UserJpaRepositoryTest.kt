package me.choicore.api.authenticator.infrastructure.repository

import me.choicore.api.authenticator.infrastructure.SpringBootDataJpaTest
import me.choicore.api.authenticator.infrastructure.entity.UserEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired


@SpringBootDataJpaTest
class UserJpaRepositoryTest @Autowired constructor(
    private val userJpaRepository: UserJpaRepository,
) {
    @Test
    fun `test register user`() {
        val userEntity = userJpaRepository.save(
            UserEntity(
                nickname = "choicore",
            ),
        )
        userJpaRepository.flush()
        println(userEntity.toString())
        println(userEntity.registeredAt)
        println(userEntity.modifiedAt)
        assertThat(userEntity).isNotNull
    }
}
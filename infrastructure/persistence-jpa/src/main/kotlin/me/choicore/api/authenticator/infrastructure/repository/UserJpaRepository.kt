package me.choicore.api.authenticator.infrastructure.repository

import me.choicore.api.authenticator.infrastructure.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component


@Component
interface UserJpaRepository : JpaRepository<UserEntity, Long>
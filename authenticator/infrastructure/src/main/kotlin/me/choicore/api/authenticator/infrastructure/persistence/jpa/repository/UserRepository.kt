package me.choicore.api.authenticator.infrastructure.persistence.jpa.repository

import me.choicore.api.authenticator.infrastructure.persistence.jpa.model.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, Long>
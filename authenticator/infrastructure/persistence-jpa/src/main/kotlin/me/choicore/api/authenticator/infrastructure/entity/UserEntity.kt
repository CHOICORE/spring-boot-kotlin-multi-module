package me.choicore.api.authenticator.infrastructure.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import me.choicore.api.authenticator.infrastructure.common.BaseEntity


@Entity
@Table(name = "user")
class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nickname: String,
) : BaseEntity()


package me.choicore.api.authenticator.infrastructure.common

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity {

    @CreatedDate
    @Column(
        insertable = true,
        updatable = false,
    )
    val registeredAt: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate
    @Column(
        insertable = false,
        updatable = true,
    )
    val modifiedAt: LocalDateTime = LocalDateTime.now()
}
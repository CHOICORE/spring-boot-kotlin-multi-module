package me.choicore.api.authenticator.infrastructure

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration


@ComponentScan
@EnableAutoConfiguration
internal class SpringBootDataJpaTestContextConfiguration

@ActiveProfiles("infrastructure-local")
@DataJpaTest
@ContextConfiguration(classes = [SpringBootDataJpaTestContextConfiguration::class])
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
annotation class SpringBootDataJpaTest


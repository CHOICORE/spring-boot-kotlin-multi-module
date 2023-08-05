plugins {
    id("plugins.conventions.kotlin-with-spring-convention")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
    implementation(project(":authenticator-domain"))
    implementation(project(":authenticator-presentation"))
    testImplementation("org.springframework.security:spring-security-test")
}

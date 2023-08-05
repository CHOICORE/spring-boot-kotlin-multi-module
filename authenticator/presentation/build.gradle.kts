plugins {
    id("plugins.conventions.kotlin-with-spring-convention")
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":authenticator-domain"))
}

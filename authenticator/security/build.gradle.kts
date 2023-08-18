plugins {
    id("plugins.conventions.kotlin-with-spring-convention")
}

tasks {
    bootJar {
        enabled = false
    }
    jar {
        enabled = true
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
    implementation(project(":domain"))
    implementation(project(":presentation"))
    testImplementation("org.springframework.security:spring-security-test")
}

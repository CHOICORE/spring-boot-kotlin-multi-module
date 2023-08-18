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
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(project(":domain"))
}

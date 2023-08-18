plugins {
    id("plugins.conventions.kotlin-with-spring-convention")
    alias(libs.plugins.kotlin.jpa)
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

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation(project(":domain"))

    runtimeOnly("com.h2database:h2")

    testImplementation("com.h2database:h2")
}
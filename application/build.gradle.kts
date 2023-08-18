plugins {
    id("plugins.conventions.kotlin-with-spring-convention")
}

tasks.bootJar {
    enabled = true
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":infrastructure:persistence-jpa"))
}

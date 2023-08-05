plugins {
    id("plugins.conventions.kotlin-with-spring-convention")
    alias(libs.plugins.kotlin.jpa)
}

dependencies {
    implementation(project(":authenticator-domain"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")

//    testImplementation(project(":authenticator-application"))
    testImplementation("com.h2database:h2")

}
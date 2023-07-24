dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation(project(":authenticator-presentation"))
    implementation(project(":authenticator-domain"))
    implementation(project(":authenticator-infrastructure"))
}

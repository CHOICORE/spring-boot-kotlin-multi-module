package plugins.conventions

val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

plugins {
    id("plugins.bases.java-base")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}
configurations {

    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }

    all {
        exclude(group = "org.junit.platform", module = "junit-platform-launcher")
        exclude(group = "org.junit.jupiter", module = "junit-jupiter-api")
        exclude(group = "org.junit.jupiter", module = "junit-jupiter-params")
        exclude(group = "org.assertj", module = "assertj-core")
    }
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

springBoot {
    // Creates META-INF/build-info.properties for Spring Boot Actuator
    buildInfo()
}

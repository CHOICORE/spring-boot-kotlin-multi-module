plugins {
    kotlin("jvm")
}

dependencies {
    testRuntimeOnly(libs.junit.jupiter.engine)
    testImplementation(libs.bundles.junit)
}


tasks {
    withType<Test> {
        useJUnitPlatform()
    }
}

plugins {
    id("plugins.bases.kotlin-base")
}

tasks.jar {
    enabled = true
}

dependencies {
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.bundles.junit)
}
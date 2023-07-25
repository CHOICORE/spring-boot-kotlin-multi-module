plugins {
    id("plugins.bases.kotlin-base")
}

dependencies {
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.bundles.junit)
}
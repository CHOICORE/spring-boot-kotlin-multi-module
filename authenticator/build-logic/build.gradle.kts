import org.gradle.accessors.dm.LibrariesForLibs

val libraries: LibrariesForLibs = libs

plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.gradlePlugin.springBoot)
    implementation(libs.gradlePlugin.kotlin)
}
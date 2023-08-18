package plugins.conventions

import gradle.kotlin.dsl.accessors._395657bf3ced2279daa1b6a2efc8247b.implementation

val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

plugins {
    id("plugins.conventions.spring-convention")
    id("plugins.bases.kotlin-base")
    kotlin("plugin.spring")
}

configurations {
    all {
        exclude(group = "org.projectlombok", module = "lombok")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-allopen")
}
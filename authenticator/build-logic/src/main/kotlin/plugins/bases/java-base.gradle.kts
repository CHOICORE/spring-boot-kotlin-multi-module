package plugins.bases

import gradle.kotlin.dsl.accessors._ff1654f0f9f36e3117440686fe8f247a.annotationProcessor
import gradle.kotlin.dsl.accessors._ff1654f0f9f36e3117440686fe8f247a.compileOnly

val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

plugins {
    id("plugins.bases.jvm-base")
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    compileOnly(libs.findLibrary("lombok").get())
}
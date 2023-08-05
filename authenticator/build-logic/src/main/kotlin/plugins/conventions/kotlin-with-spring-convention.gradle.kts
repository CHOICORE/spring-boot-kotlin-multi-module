package plugins.conventions

val libs: VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

plugins {
    id("plugins.conventions.spring-convention")
    id("plugins.bases.kotlin-base")
    kotlin("plugin.spring")
}
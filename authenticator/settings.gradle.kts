rootProject.name = "authenticator"

include("domain", "application", "infrastructure", "presentation")

rootProject.children.forEach {
    it.buildFileName = "${it.name}.gradle.kts"
    println("module : '${it.buildFileName}' is applied.")
}

pluginManagement {
    repositories {
        mavenCentral()
    }
}
dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    this.repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)


    @Suppress("UnstableApiUsage")
    this.repositories {
        mavenCentral()
    }
}


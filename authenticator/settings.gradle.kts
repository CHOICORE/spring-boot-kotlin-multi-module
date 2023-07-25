dependencyResolutionManagement {
    includeBuild("build-logic")
    @Suppress("UnstableApiUsage")
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

val modules: MutableList<Module> = mutableListOf()

//module(name = ":authenticator-application", projectDir = "application")
module(name = ":authenticator-domain", projectDir = "domain")
//module(name = ":authenticator-infrastructure", projectDir = "infrastructure")
//module(name = ":authenticator-presentation", projectDir = "presentation")

data class Module(
    val name: String,
    val projectDir: String,
)

fun module(name: String, projectDir: String) {
    modules.add(
        Module(
            name = name,
            projectDir = "${rootDir}/${projectDir}",
        )
    )
}

modules.forEach { module ->
    include(module.name)
    project(module.name).projectDir = file(module.projectDir)
}

rootProject.name = "authenticator"
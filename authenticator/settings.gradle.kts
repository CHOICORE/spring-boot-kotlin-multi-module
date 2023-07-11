rootProject.name = "authenticator"

include("domain", "application", "infrastructure", "presentation")

rootProject.children.forEach {
    it.buildFileName = "${it.name}.gradle.kts"

    println("module : '${it.buildFileName}' is applied.")
}
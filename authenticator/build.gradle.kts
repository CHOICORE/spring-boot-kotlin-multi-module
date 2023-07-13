import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.spring.boot) apply false
}

// 전체 프로젝트 설정
allprojects {
    group = "me.choicore.api.authenticator"
    version = "0.0.1-SNAPSHOT"
}

val jvm: String = libs.versions.jvm.get()
val kotlinReflect: MinimalExternalModuleDependency = libs.kotlin.reflect.get()

// 하위 모듈 설정
subprojects {
    val module = project.name

    apply(plugin = "kotlin")

    // domain 모듈은 spring boot 의존성을 주입하지 않는다.
    if (module != "domain") {
        apply(plugin = "kotlin-spring")
        println("module : '${module}' spring boot dependencies injected.")
    }

    dependencies {


        implementation(kotlinReflect)

        // domain 모듈은 spring boot 의존성을 주입하지 않는다.
        if (module != "domain") {

            implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))

            testImplementation("org.springframework.boot:spring-boot-starter-test")
        }

        testImplementation(kotlin("test"))

    }

    kotlin {
        jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of(jvm))
        }
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    tasks {

        withType(BootJar::class) {
            this.enabled = module == "application"
        }

        withType<Jar> {
            this.enabled = true
        }

        withType<KotlinCompile> {
            kotlinOptions {
                this.freeCompilerArgs = listOf("-Xjsr305=strict")
                this.jvmTarget = jvm
            }
        }
        withType<Test> {
            useJUnitPlatform()
        }
    }

}
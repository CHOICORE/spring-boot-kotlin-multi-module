import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("jvm") version "1.9.0"
    id("org.springframework.boot") version "3.1.1" apply false
    kotlin("plugin.spring") version "1.9.0" apply false
}

// 전체 프로젝트 설정
allprojects {
    group = "me.choicore.api.authenticator"
    version = "0.0.1-SNAPSHOT"
    repositories {
        mavenCentral()
    }
}

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

        implementation("org.jetbrains.kotlin:kotlin-reflect")

        // domain 모듈은 spring boot 의존성을 주입하지 않는다.
        if (module != "domain") {
            implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
            testImplementation("org.springframework.boot:spring-boot-starter-test")
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        sourceSets["main"].java.srcDirs("src/main/kotlin")
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    tasks {

        withType(BootJar::class) {
            enabled = module == "application"
        }

        withType<Jar> {
            enabled = true
        }

        withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "17"
            }
        }
        withType<Test> {
            useJUnitPlatform()
        }
    }

}
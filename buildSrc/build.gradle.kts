plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("com.multithrifter.module-configurator") {
            id = "com.multithrifter.module-configurator"
            implementationClass = "configurator.ModuleConfiguratorPlugin"
        }
    }
}

task("generateModuleNames") {
    val genDir = "build/gen"
    sourceSets {
        main {
            java {
                srcDir(genDir)
            }
        }
    }

    val rootDir = project.projectDir.parentFile!!
    val moduleDir = File(rootDir, "modules")
    println("modules dir = ${moduleDir.absolutePath}")

    val modules = mutableSetOf<Pair<String, String>>()
    findModules(moduleDir, modules)
    println("total modules: ${modules.size}")

    if (modules.isNotEmpty()) {
        val content = buildString {
            appendLine("sealed class MultiThrifterModule(val name: String, val path: String) {")

            modules.forEach { (name, path) ->
                var className = name.replace("-", "").replace("_", "")
                if (className.isNotEmpty()) {
                    className = className.substring(0, 1).toUpperCase() + className.substring(1)
                }
                append(" ".repeat(4))
                appendLine("object $className : MultiThrifterModule(\"${name}\", \"${path}\")")
            }

            appendLine("}")

        }

        file(genDir).mkdirs()
        file("$genDir/MultiThrifterModule.kt").writeText(content)
    }
}

fun findModules(dir: File, modules: MutableSet<Pair<String, String>>) {
    if (dir.isFile) return

    val buildFile = dir.listFiles().find { (it.name == "build.gradle" || it.name == "build.gradle.kts") && it.isFile }

    if (buildFile != null) {
        modules.add(dir.name to ":${dir.name}")
    } else {
        dir.listFiles().forEach {
            findModules(it, modules)
        }
    }
}

repositories {
    gradlePluginPortal()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.4.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    implementation("com.github.ben-manes:gradle-versions-plugin:0.46.0")
}
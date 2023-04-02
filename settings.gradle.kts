rootProject.name = "multi-thrifter"

pluginManagement {

    repositories {
        gradlePluginPortal()
        google()
    }
}

include(":app")
val appProject = project(":app")
appProject.projectDir = File(rootDir, "modules/app")
appProject.name = "app"

includeAllModules("$rootDir/modules/common")
includeAllModules("$rootDir/modules/feature")

fun includeAllModules(dir: String) {
    File(dir).listFiles()?.filter { it.isDirectory }?.forEach { module ->
        val moduleName = module.name
        if (isGradleModule(module)) {
            includeModule(moduleName, dir)
        }
    }
}

// Если в директории есть файл build.gradle, то это модуль
fun isGradleModule(file: File): Boolean {
    val gradleFile = File("${file.absolutePath}/build.gradle")
    val gradleFileKts = File("${file.absolutePath}/build.gradle.kts")
    return gradleFile.exists() || gradleFileKts.exists()
}

fun includeModule(moduleName: String, dir: String) {
    include(":$moduleName")
    project(":$moduleName").projectDir = File("$dir/$moduleName")
}

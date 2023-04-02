buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Plugins.ClassPath.GRADLE_TOOLS)
        classpath(Plugins.ClassPath.KOTLIN)
        classpath(Plugins.ClassPath.PLUGIN_UPDATES_CHECKER)
    }
}

apply(plugin = Plugins.Project.MODULE_CONFIGURATOR)

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    apply(plugin = Plugins.Project.MODULE_CONFIGURATOR)
}
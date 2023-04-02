package configurator

import com.android.build.gradle.AppExtension
import com.android.build.gradle.ProguardFiles
import org.gradle.api.Project

class AndroidSettingsApplicationConfigurator : ProjectConfigurator {

    override fun configure(project: Project) {
        val androidExtension = project.extensions.getByName("android")
        if (androidExtension is AppExtension) {
            androidExtension.apply {
                buildTypesConfiguration(project)
            }
        } else {
            project.logger.error("Failed to configure android settings for application module")
        }
    }

    /**
     * buildTypes для апп модулей.
     * Индивидуальные настройки для debug/release версий.
     * Настройки подписи приложения.
     */
    private fun AppExtension.buildTypesConfiguration(project: Project) {
        buildTypes {
            val proguardFiles = project.rootProject.fileTree("proguard").files +
                getDefaultProguardFile("proguard-android-optimize.txt")

            getByName("debug") {
                isDebuggable = true
                isMinifyEnabled = false
                isShrinkResources = false
                proguardFiles(*proguardFiles.toTypedArray())
                signingConfig = signingConfigs.getByName("debug")
            }

            getByName("release") {
                isDebuggable = false
                isMinifyEnabled = true
                isShrinkResources = true
                proguardFiles(*proguardFiles.toTypedArray())
                //signingConfig = signingConfigs.getByName("release")
            }
        }
    }
}
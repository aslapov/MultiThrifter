package configurator

import Versions
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AndroidSettingsCommonConfigurator : ProjectConfigurator {

    private companion object {
        val javaVersion = JavaVersion.VERSION_1_8
    }

    override fun configure(project: Project) {
        val androidExtension = project.extensions.getByName("android")

        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                compileSdkVersion(Android.COMPILE_SDK)
                buildToolsVersion(Android.BUILD_TOOLS)
                defaultConfigConfiguration()
                buildTypesConfiguration()
                compileOptionsConfiguration()
                composeConfiguration(project)
            }
        } else {
            project.logger.error("Failed to configure android settings for ${project.name} module")
        }
        kotlinOptionsConfiguration(project)
        configureKapt(project)
    }

    /**
     * defaultConfig для всех модулей, включая апп.
     */
    private fun BaseExtension.defaultConfigConfiguration() {
        defaultConfig {
            minSdk = Android.MIN_SDK
            targetSdk = Android.TARGET_SDK
            versionCode = Versions.APP_VERSION_CODE
            versionName = Versions.APP_VERSION_NAME

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables.useSupportLibrary = true
        }
    }

    /**
     * buildTypes для всех модулей, включая апп.
     * Индивидуальные настройки для debug/release версий.
     *
     * Отключает минификации для каждого модуля. В апп модуле это перезаписывается.
     */
    private fun BaseExtension.buildTypesConfiguration() {
        buildTypes {
            named("debug") {
                isMinifyEnabled = false
            }

            named("release") {
                isMinifyEnabled = false
                setConsumerProguardFiles(listOf("proguard-rules.pro"))
            }
        }
    }

    /**
     * compileOptions для всех модулей, включая апп.
     */
    private fun BaseExtension.compileOptionsConfiguration() {
        compileOptions {
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
        }
    }

    /**
     * конфигурация для модулей, использующих compose
     */
    private fun BaseExtension.composeConfiguration(project: Project) {
        if (project.name !in Exclusions.COMPOSE) {
            buildFeatures.compose = true
            composeOptions.kotlinCompilerExtensionVersion = Versions.COMPOSE_COMPILER
        }
    }

    /**
     * kotlinOptions для всех модулей, включая апп.
     */
    private fun kotlinOptionsConfiguration(project: Project) {
        project.tasks.withType<KotlinCompile> {
            kotlinOptions.jvmTarget = javaVersion.toString()
        }
    }

    /**
     * конфигурация всех kapt тасок
     */
    private fun configureKapt(project: Project) {
        val kaptExtension = project.extensions.findByName("kapt")
        if (kaptExtension is KaptExtension) {
            kaptExtension.apply {
                // see https://kotlinlang.org/docs/kapt.html#non-existent-type-correction
                correctErrorTypes = true
                // see https://kotlinlang.org/docs/kapt.html#compile-avoidance-for-kapt
                includeCompileClasspath = false
            }
        } else {
            // kaptExtension - null, если плагин капт в модуле не подключен
            project.logger.debug("Module ${project.name} has no kapt dependencies")
        }
    }
}
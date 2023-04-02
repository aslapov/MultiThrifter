package configurator

import Plugins
import org.gradle.api.Project

/**
 * Добавляет плагины во все модули, кроме рутового.
 */
class PluginsCommonConfigurator : ProjectConfigurator {

    override fun configure(project: Project) {
        project.plugins.apply(Plugins.Project.KOTLIN_ANDROID)
        project.plugins.apply(Plugins.Project.KOTLIN_PARCELIZE)
        if (project.name !in Exclusions.KAPT) {
            project.plugins.apply(Plugins.Project.KOTLIN_KAPT)
        }
    }
}
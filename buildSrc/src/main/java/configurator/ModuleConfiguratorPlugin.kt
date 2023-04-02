package configurator

import org.gradle.api.Plugin
import org.gradle.api.Project

class ModuleConfiguratorPlugin : Plugin<Project> {

    private companion object {
        const val ROOT_PROJECT = "multi-thrifter"
        const val APPLICATION_PROJECT = "app"
    }

    private val rootConfigurators: List<ProjectConfigurator> = listOf(
        TaskCleanConfigurator(),
        TaskDependencyUpdatesConfigurator(),
    )

    private val commonModuleConfigurators: List<ProjectConfigurator> = listOf(
        PluginsCommonConfigurator(),
        AndroidSettingsCommonConfigurator(),
        DependenciesCommonConfigurator(),
        TaskDependenciesReportConfigurator(),
    )

    private val applicationSpecificConfigurators: List<ProjectConfigurator> = listOf(
        AndroidSettingsApplicationConfigurator(),
    )

    /**
     * точка входа в плагин
     */
    override fun apply(project: Project) {
        project.logger.debug("Configuring ${project.name} module")
        when {
            ROOT_PROJECT == project.name -> configureRootProject(project)
            APPLICATION_PROJECT == project.name -> configureApplicationProject(project)
            else -> configureModule(project)
        }
    }

    /**
     * Конфигурирует рутовый модуль (multi-thrifter)
     */
    private fun configureRootProject(project: Project) {
        rootConfigurators.forEach { configurator -> configurator.configure(project) }
    }

    private fun configureApplicationProject(project: Project) {
        project.plugins.apply(Plugins.Project.APP_MODULE)
        commonModuleConfigurators.forEach { configurator -> configurator.configure(project) }
        applicationSpecificConfigurators.forEach { configurator -> configurator.configure(project) }
    }

    private fun configureModule(project: Project) {
        project.plugins.apply(Plugins.Project.LIBRARY_MODULE)
        commonModuleConfigurators.forEach { configurator -> configurator.configure(project) }
    }
}
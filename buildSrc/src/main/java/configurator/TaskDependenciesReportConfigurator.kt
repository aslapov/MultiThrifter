package configurator

import org.gradle.api.Project
import org.gradle.api.tasks.diagnostics.DependencyReportTask
import org.gradle.kotlin.dsl.register

/**
 * Добавляет таску allDeps, которая показывает все зависимости всех тасок модуля либо всего проекта.
 * @sample ./gradlew allDeps
 * @sample ./gradlew :core:allDeps
 */
class TaskDependenciesReportConfigurator : ProjectConfigurator {

    override fun configure(project: Project) {
        project.tasks.register<DependencyReportTask>("allDeps")
    }
}
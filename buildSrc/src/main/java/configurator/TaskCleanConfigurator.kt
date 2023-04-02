package configurator

import org.gradle.api.Project
import org.gradle.api.tasks.Delete
import org.gradle.kotlin.dsl.register

class TaskCleanConfigurator : ProjectConfigurator {

    override fun configure(project: Project) {
        project.tasks.register<Delete>("clean") {
            delete(project.rootProject.buildDir)
        }
    }
}
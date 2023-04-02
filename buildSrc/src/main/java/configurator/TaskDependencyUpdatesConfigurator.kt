package configurator

import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType

/**
 * Настройка плагина для проверки версий используемых библиотек
 * @sample ./gradlew dependencyUpdates
 */
class TaskDependencyUpdatesConfigurator : ProjectConfigurator {
    private val stableRegex = "^[0-9,.v-]+(-r)?$".toRegex()
    private val stableKeywords = listOf("RELEASE", "FINAL", "GA")

    override fun configure(project: Project) {
        project.tasks.withType<DependencyUpdatesTask> {
            rejectVersionIf {
                !isStable(candidate.version) && isStable(currentVersion)
            }
            checkForGradleUpdate = true
            outputFormatter = "html"
            outputDir = "build/dependencyUpdates"
            reportfileName = "report"
        }
    }

    fun isStable(version: String): Boolean {
        val stableKeyword = stableKeywords.any { version.toUpperCase().contains(it) }
        val isStable = stableKeyword || stableRegex.matches(version)
        return isStable
    }
}
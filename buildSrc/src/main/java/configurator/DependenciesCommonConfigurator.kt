package configurator

import Exclusions
import Libraries
import MultiThrifterModule
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Добавляет общие зависимости во все модули, включая апп,
 */
class DependenciesCommonConfigurator : ProjectConfigurator {

    companion object {
        private const val IMPLEMENTATION = "implementation"
        private const val TEST_IMPLEMENTATION = "testImplementation"
        private const val TEST_RUNTIME_ONLY = "testRuntimeOnly"
        private const val KAPT = "kapt"
    }

    @Suppress("LongMethod")
    override fun configure(project: Project) {
        project.configurationScope {
            testImplementation(MultiThrifterModule.Coretest) {
                ignoreFor(MultiThrifterModule.Core)
            }

            implementation(MultiThrifterModule.Core) {
                ignoreFor(MultiThrifterModule.Ui)
            }

            if (this.project.name !in Exclusions.COMPOSE) {
                implementation(MultiThrifterModule.Ui)
            }

            testLibs()

            if (this.project.name !in Exclusions.KAPT) {
                add(IMPLEMENTATION, Libraries.DI.DAGGER_2)
                add(KAPT, AnnotationProcessors.DAGGER_2)
            }
        }
    }

    private fun DependencyHandler.testLibs() {
        add(TEST_IMPLEMENTATION, Libraries.Test.JUNIT_API)
        add(TEST_IMPLEMENTATION, Libraries.Test.JUNIT_PARAMS)
        add(TEST_IMPLEMENTATION, Libraries.Test.JUNIT_EXTENSIVE)
        add(TEST_RUNTIME_ONLY, Libraries.Test.JUNIT_ENGINE)
        add(TEST_IMPLEMENTATION, Libraries.Test.MOCKITO)
        add(TEST_IMPLEMENTATION, Libraries.Test.MOCKITO_JUPITER)
        add(TEST_IMPLEMENTATION, Libraries.Test.MOCKITO_INLINE)
        add(TEST_IMPLEMENTATION, Libraries.Test.MOCKITO_KOTLIN)
        add(TEST_IMPLEMENTATION, Libraries.Test.MOCKK)
        add(TEST_IMPLEMENTATION, Libraries.Test.ASSERT_J)
        add(TEST_IMPLEMENTATION, Libraries.Test.COROUTINES_TEST)
    }
}
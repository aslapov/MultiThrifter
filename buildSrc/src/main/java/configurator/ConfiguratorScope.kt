package configurator

import MultiThrifterModule
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler

class ConfiguratorScope(val project: Project) : DependencyHandler by project.dependencies {

    interface Properties {
        fun ignoreFor(vararg modules: MultiThrifterModule)
    }

    fun implementation(module: MultiThrifterModule, properties: (Properties.() -> Unit)? = null) {
        add("implementation", module, properties)
    }

    fun testImplementation(module: MultiThrifterModule, properties: (Properties.() -> Unit)? = null) {
        add("testImplementation", module, properties)
    }

    fun add(configurationName: String, module: MultiThrifterModule, properties: (Properties.() -> Unit)? = null) {
        if (module.name != project.name) {
            if (properties == null) {
                add(configurationName, project.project(module.path))
            } else {
                val prop = PropImpl().apply(properties)

                if (project.name !in prop.ignoreList) {
                    add(configurationName, project.project(module.path))
                }
            }
        }
    }

    private class PropImpl : Properties {

        val ignoreList: MutableList<String> = mutableListOf()

        override fun ignoreFor(vararg modules: MultiThrifterModule) {
            ignoreList += modules.map { it.name }
        }
    }
}

fun Project.configurationScope(scope: ConfiguratorScope.() -> Unit) {
    ConfiguratorScope(this).apply(scope)
}
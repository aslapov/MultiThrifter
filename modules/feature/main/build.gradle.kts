plugins {
    kotlin("plugin.serialization") version Versions.KOTLIN
}

android {
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(MultiThrifterModule.Dbapi.path))
    implementation(project(MultiThrifterModule.Db.path))
    implementation(project(MultiThrifterModule.Networkapi.path))
    implementation(project(MultiThrifterModule.Network.path))

    implementation(Libraries.Support.ANDROID_X_CORE)
    implementation(Libraries.Support.ANDROID_X_CORE_KTX)
    implementation(Libraries.Support.APP_COMPAT)
    implementation(Libraries.Support.LIFECYCLE_RUNTIME)
    implementation(Libraries.Support.VIEW_MODEL_KTX)
    implementation(Libraries.Support.CONSTRAINT_LAYOUT)
    implementation(Libraries.Support.DESIGN)
    implementation(Libraries.Support.ANDROID_X_ACTIVITY_KTX)
    implementation(Libraries.Support.ANDROID_X_FRAGMENT_KTX)

    implementation(Libraries.Kotlin.COROUTINES_ANDROID)
    implementation(Libraries.Kotlin.SERIALIZATION_CORE)
    implementation(Libraries.Kotlin.SERIALIZATION_JSON)

    implementation(Libraries.Network.RETROFIT_2)
}
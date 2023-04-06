object Versions {
    const val APP_VERSION_NAME = "1.0"
    const val APP_VERSION_CODE = 1

    const val ANDROID_GRADLE_PLUGIN = "7.4.2"
    const val KOTLIN = "1.8.0"
    const val PLUGIN_UPDATES_CHECKER = "0.46.0"

    const val KOTLIN_SERIALIZATION = "1.5.0"
    const val COROUTINES_VERSION = "1.6.4"
    const val DAGGER_2 = "2.45"
    const val ROOM = "2.5.1"
    const val JAVAX_INJECT = "1"
    const val APP_COMPAT = "1.2.0"
    const val MATERIAL_DESIGN = "1.3.0"
    const val CONSTRAINT_LAYOUT = "2.1.1"
    const val ANDROID_X_CORE = "1.1.0"
    const val ANDROID_X_FRAGMENT = "1.3.6"
    const val LIFECYCLE = "2.4.1"
    const val OK_HTTP_3 = "4.9.1"
    const val RETROFIT_2 = "2.9.0"
    const val RETROFIT_KOTLINX_CONVERTER = "0.8.0"
    const val JETPACK_NAVIGATION = "2.3.5"
    const val TIMBER = "5.0.1"

    // Compose
    const val COMPOSE = "1.4.0"
    const val COMPOSE_COMPILER = "1.4.0"
    const val COMPOSE_MATERIAL = "1.4.0"
    const val COMPOSE_CONSTRAINT_LAYOUT = "1.0.1"

    // test
    const val MOCKK = "1.9.3"
    const val JUNIT = "5.8.2"
    const val ASSERT_J = "3.13.1"
    const val MOCKITO = "4.0.0"
}

object Libraries {

    object Kotlin {
        const val STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
        const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_VERSION}"
        const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
        const val SERIALIZATION_JSON =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.KOTLIN_SERIALIZATION}"
        const val SERIALIZATION_CORE =
            "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.KOTLIN_SERIALIZATION}"
    }

    object Support {
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val DESIGN = "com.google.android.material:material:${Versions.MATERIAL_DESIGN}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
        const val ANDROID_X_CORE = "androidx.core:core:${Versions.ANDROID_X_CORE}"
        const val ANDROID_X_CORE_KTX = "androidx.core:core-ktx:${Versions.ANDROID_X_CORE}"
        const val ANDROID_X_FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.ANDROID_X_FRAGMENT}"
        const val VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
        const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
        const val JETPACK_NAVIGATION_FRAGMENT_KTX = "androidx.navigation:navigation-fragment-ktx:${Versions.JETPACK_NAVIGATION}"
        const val JETPACK_NAVIGATION_UI_KTX = "androidx.navigation:navigation-ui-ktx:${Versions.JETPACK_NAVIGATION}"
    }

    object Compose {
        const val RUNTIME = "androidx.compose.runtime:runtime:${Versions.COMPOSE}"
        const val FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"
        const val MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
        const val UI_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
        const val COMPILER = "androidx.compose.compiler:compiler:${Versions.COMPOSE_COMPILER}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout-compose:${Versions.COMPOSE_CONSTRAINT_LAYOUT}"
    }

    object DI {
        const val DAGGER_2 = "com.google.dagger:dagger:${Versions.DAGGER_2}"
        const val INJECT = "javax.inject:javax.inject:${Versions.JAVAX_INJECT}"
    }

    object DB {
        const val ROOM = "androidx.room:room-runtime:${Versions.ROOM}"
        const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"
        const val ROOM_MIGRATION = "androidx.room:room-migration:${Versions.ROOM}"
    }

    object Network {
        const val OK_HTTP = "com.squareup.okhttp3:okhttp:${Versions.OK_HTTP_3}"
        const val OK_HTTP_URL_CONNECTION = "com.squareup.okhttp3:okhttp-urlconnection:${Versions.OK_HTTP_3}"
        const val OK_HTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:${Versions.OK_HTTP_3}"
        const val RETROFIT_2 = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_2}"
        const val RETROFIT_2_KOTLINX_CONVERTER =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.RETROFIT_KOTLINX_CONVERTER}"
        const val RETROFIT_2_MOCK = "com.squareup.retrofit2:retrofit-mock:${Versions.RETROFIT_2}"
    }

    object Test {
        const val JUNIT_API = "org.junit.jupiter:junit-jupiter-api:${Versions.JUNIT}"
        const val JUNIT_ENGINE = "org.junit.jupiter:junit-jupiter-engine:${Versions.JUNIT}"
        const val JUNIT_PARAMS = "org.junit.jupiter:junit-jupiter-params:${Versions.JUNIT}"
        const val MOCKITO = "org.mockito:mockito-core:${Versions.MOCKITO}"
        const val MOCKITO_JUPITER = "org.mockito:mockito-junit-jupiter:${Versions.MOCKITO}"
        const val MOCKITO_INLINE = "org.mockito:mockito-inline:${Versions.MOCKITO}"
        const val MOCKITO_KOTLIN = "org.mockito.kotlin:mockito-kotlin:${Versions.MOCKITO}"
        const val ASSERT_J = "org.assertj:assertj-core:${Versions.ASSERT_J}"
        const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
        const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES_VERSION}"
    }

    object Utils {
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    }
}

object Plugins {

    object ClassPath {
        const val GRADLE_TOOLS = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
        const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val PLUGIN_UPDATES_CHECKER = "com.github.ben-manes:gradle-versions-plugin:${Versions.PLUGIN_UPDATES_CHECKER}"
    }

    object Project {
        const val APP_MODULE = "com.android.application"
        const val LIBRARY_MODULE = "com.android.library"
        const val MODULE_CONFIGURATOR = "com.multithrifter.module-configurator"
        const val KOTLIN_ANDROID = "kotlin-android"
        const val KOTLIN_PARCELIZE = "kotlin-parcelize"
        const val KOTLIN_KAPT = "kotlin-kapt"
    }
}

object AnnotationProcessors {
    const val DAGGER_2 = "com.google.dagger:dagger-compiler:${Versions.DAGGER_2}"
    const val ROOM = "androidx.room:room-compiler:${Versions.ROOM}"
}

object Android {
    const val MIN_SDK = 23
    const val TARGET_SDK = 33
    const val COMPILE_SDK = 33
    const val BUILD_TOOLS = "33.0.0"
}

object Exclusions {
    val KAPT = setOf(
        MultiThrifterModule.Coretest.name,
    )

    val COMPOSE = setOf(
        MultiThrifterModule.App.name,
        MultiThrifterModule.Core.name,
        MultiThrifterModule.Main.name,
        MultiThrifterModule.Network.name,
        MultiThrifterModule.Networkapi.name,
        MultiThrifterModule.Networkimpl.name,
        MultiThrifterModule.Db.name,
        MultiThrifterModule.Dbapi.name,
        MultiThrifterModule.Dbimpl.name,
        MultiThrifterModule.Coretest.name,
    )
}
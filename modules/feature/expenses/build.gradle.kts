dependencies {
    implementation(project(MultiThrifterModule.Dbapi.path))
    implementation(project(MultiThrifterModule.Db.path))
    implementation(project(MultiThrifterModule.Networkapi.path))
    implementation(project(MultiThrifterModule.Network.path))

    implementation(Libraries.Support.APP_COMPAT)
    implementation(Libraries.Support.ANDROID_X_CORE)
    implementation(Libraries.Support.ANDROID_X_CORE_KTX)
    implementation(Libraries.Support.VIEW_MODEL_KTX)
    implementation(Libraries.Support.ANDROID_X_FRAGMENT_KTX)

    implementation(Libraries.Kotlin.COROUTINES_ANDROID)
    implementation(Libraries.Kotlin.SERIALIZATION_CORE)
    implementation(Libraries.Kotlin.SERIALIZATION_JSON)

    implementation(Libraries.Compose.FOUNDATION)
    implementation(Libraries.Compose.RUNTIME)
    implementation(Libraries.Compose.COMPILER)
    implementation(Libraries.Compose.UI_TOOLING)
    implementation(Libraries.Compose.MATERIAL)

    implementation(Libraries.Network.RETROFIT_2)
}
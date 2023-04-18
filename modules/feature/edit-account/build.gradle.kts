dependencies {
    implementation(project(MultiThrifterModule.Dbapi.path))
    implementation(project(MultiThrifterModule.Db.path))

    implementation(Libraries.Support.APP_COMPAT)
    implementation(Libraries.Support.ANDROID_X_CORE)
    implementation(Libraries.Support.ANDROID_X_CORE_KTX)
    implementation(Libraries.Support.VIEW_MODEL_KTX)
    implementation(Libraries.Support.ANDROID_X_FRAGMENT_KTX)

    implementation(Libraries.Kotlin.COROUTINES_ANDROID)

    implementation(Libraries.Compose.FOUNDATION)
    implementation(Libraries.Compose.RUNTIME)
    implementation(Libraries.Compose.COMPILER)
    implementation(Libraries.Compose.UI_TOOLING)
    implementation(Libraries.Compose.MATERIAL)
}
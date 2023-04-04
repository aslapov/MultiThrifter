dependencies {
    implementation(project(MultiThrifterModule.Dbapi.path))
    implementation(project(MultiThrifterModule.Db.path))
    implementation(project(MultiThrifterModule.Networkapi.path))
    implementation(project(MultiThrifterModule.Network.path))

    implementation(Libraries.Support.APP_COMPAT)
    implementation(Libraries.Support.ANDROID_X_CORE_KTX)
    implementation(Libraries.Support.LIFECYCLE_RUNTIME)

    implementation(Libraries.Network.RETROFIT_2)

    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(Libraries.Compose.RUNTIME)
    implementation(Libraries.Compose.COMPILER)
    implementation(Libraries.Compose.UI_TOOLING)
    implementation(Libraries.Compose.MATERIAL)
    implementation("androidx.compose.ui:ui:1.4.0")

    implementation(Libraries.Kotlin.COROUTINES_ANDROID)
}
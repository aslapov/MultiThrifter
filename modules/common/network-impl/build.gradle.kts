dependencies {
    implementation(project(MultiThrifterModule.Networkapi.path))

    implementation(Libraries.Network.OK_HTTP)
    implementation(Libraries.Network.OK_HTTP_URL_CONNECTION)
    implementation(Libraries.Network.OK_HTTP_LOGGING)
    implementation(Libraries.Network.RETROFIT_2)
    implementation(Libraries.Network.RETROFIT_2_MOCK)
    implementation(Libraries.Network.RETROFIT_2_KOTLINX_CONVERTER)

    implementation(Libraries.Kotlin.COROUTINES_CORE)
    implementation(Libraries.Kotlin.SERIALIZATION_CORE)
    implementation(Libraries.Kotlin.SERIALIZATION_JSON)

    implementation(Libraries.Utils.TIMBER)
}
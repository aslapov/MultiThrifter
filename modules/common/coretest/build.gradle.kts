dependencies {
    implementation(Libraries.Test.JUNIT_API)
    implementation(Libraries.Test.JUNIT_PARAMS)
    implementation(Libraries.Test.JUNIT_EXTENSIVE)

    runtimeOnly(Libraries.Test.JUNIT_ENGINE)

    implementation(Libraries.Test.MOCKITO)
    implementation(Libraries.Test.MOCKITO_JUPITER)
    implementation(Libraries.Test.MOCKITO_INLINE)
    implementation(Libraries.Test.MOCKITO_KOTLIN)
    implementation(Libraries.Test.MOCKK)
    implementation(Libraries.Test.ASSERT_J)
    implementation(Libraries.Test.COROUTINES_TEST)
}
android {
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Libraries.Support.ANDROID_X_CORE_KTX)
    implementation(Libraries.Support.ANDROID_X_FRAGMENT_KTX)
    implementation(Libraries.Support.APP_COMPAT)
    implementation(Libraries.Support.LIFECYCLE_RUNTIME)
    implementation(Libraries.Support.CONSTRAINT_LAYOUT)
    implementation(Libraries.Support.DESIGN)
}
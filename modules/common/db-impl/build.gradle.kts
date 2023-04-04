android {
    kapt {
        arguments {
            arg("room.incremental", "true")
        }
    }
}

dependencies {
    implementation(project(MultiThrifterModule.Dbapi.path))

    implementation(Libraries.Kotlin.COROUTINES_ANDROID)
    implementation(Libraries.DB.ROOM)
    implementation(Libraries.DB.ROOM_KTX)
    kapt(AnnotationProcessors.ROOM)
}
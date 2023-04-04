dependencies {
    implementation(project(MultiThrifterModule.Main.path))
    implementation(project(MultiThrifterModule.Db.path))
    implementation(project(MultiThrifterModule.Dbapi.path))
    implementation(project(MultiThrifterModule.Dbimpl.path))
    implementation(project(MultiThrifterModule.Network.path))
    implementation(project(MultiThrifterModule.Networkapi.path))
    implementation(project(MultiThrifterModule.Networkimpl.path))

    implementation(Libraries.Support.APP_COMPAT)
}
dependencies {
    implementation(project(MultiThrifterModule.Main.path))
    implementation(project(MultiThrifterModule.Db.path))
    implementation(project(MultiThrifterModule.Dbapi.path))
    implementation(project(MultiThrifterModule.Network.path))
    implementation(project(MultiThrifterModule.Networkapi.path))
    implementation(project(MultiThrifterModule.Accounts.path))
    implementation(project(MultiThrifterModule.Createaccount.path))
    implementation(project(MultiThrifterModule.Expenses.path))
    implementation(project(MultiThrifterModule.Incomes.path))
    implementation(project(MultiThrifterModule.Selectcurrency.path))

    implementation(Libraries.Support.APP_COMPAT)
}
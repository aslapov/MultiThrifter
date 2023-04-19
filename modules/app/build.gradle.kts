dependencies {
    implementation(project(MultiThrifterModule.Main.path))
    implementation(project(MultiThrifterModule.Db.path))
    implementation(project(MultiThrifterModule.Dbapi.path))
    implementation(project(MultiThrifterModule.Network.path))
    implementation(project(MultiThrifterModule.Networkapi.path))
    implementation(project(MultiThrifterModule.Accounts.path))
    implementation(project(MultiThrifterModule.Createaccount.path))
    implementation(project(MultiThrifterModule.Editaccount.path))
    implementation(project(MultiThrifterModule.Expenses.path))
    implementation(project(MultiThrifterModule.Incomes.path))
    implementation(project(MultiThrifterModule.Selectcurrency.path))

    implementation(Libraries.Support.APP_COMPAT)

    androidTestImplementation(Libraries.Test.JUNIT_EXTENSIVE)
    androidTestImplementation(Libraries.Test.JUNIT_COMPOSE)
    androidTestImplementation(Libraries.Test.MOCKITO_KOTLIN)
    androidTestImplementation(Libraries.Test.MOCKITO_ANDROID)
    androidTestImplementation(Libraries.Test.ASSERT_J)
    androidTestImplementation(Libraries.Test.KASPRESSO)
    androidTestImplementation(Libraries.Test.ESPRESSO_INTENTS)
    androidTestImplementation(Libraries.Test.UI_AUTOMATOR)
    androidTestImplementation(Libraries.Support.DESIGN)

    androidTestUtil(Libraries.Test.ORCHESTRATOR)
}
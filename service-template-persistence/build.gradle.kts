apply<IntegrationTestsPlugin>()

dependencies {

    implementation(project(":service-chassis-persistence"))
    implementation(project(":service-template-domain"))
    implementation(project(":service-template-config"))

    testImplementation(project(":service-template-test-data"))
    testImplementation(project(":service-chassis-test-containers"))


}

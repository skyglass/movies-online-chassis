apply<IntegrationTestsPlugin>()
apply<RestAssuredTestDependenciesPlugin>()

dependencies {

    implementation(project(":service-chassis-util"))
    implementation(project(":service-template-domain"))

    implementation(project(":service-chassis-web"))


    testImplementation(project(":service-template-test-data"))
    testImplementation(project(":service-chassis-test-containers"))

}

tasks.findByName("check")!!.shouldRunAfter(":service-template-domain:check")

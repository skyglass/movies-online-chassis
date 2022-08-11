plugins {
    id("TestReporter")
}

apply<IntegrationTestsPlugin>()
apply<RestAssuredTestDependenciesPlugin>()

dependencies {
    testImplementation(project(":service-chassis-health-check"))

    testImplementation(project(":service-template-domain"))
    testImplementation(project(":service-chassis-util"))

    testImplementation(project(":service-template-persistence"))
    testImplementation(project(":service-template-test-data"))
    testImplementation(project(":service-chassis-test-containers"))
    testImplementation(project(":service-chassis-test-util"))

    runtimeOnly("mysql:mysql-connector-java")

}

tasks.findByName("check")!!.shouldRunAfter(":service-template-domain:check")

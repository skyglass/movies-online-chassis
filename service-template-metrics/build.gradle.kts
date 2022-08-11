plugins {
    id("TestReporter")
}

apply<IntegrationTestsPlugin>()
apply<RestAssuredTestDependenciesPlugin>()

dependencies {
    implementation(project(":service-template-domain"))
    implementation(project(":service-chassis-util"))

    implementation(project(":service-chassis-metrics"))

    testImplementation(project(":service-chassis-test-util"))
    testImplementation(project(":service-template-config"))
    testImplementation(project(":service-template-test-data"))
    testImplementation(project(":service-chassis-test-containers"))
    testImplementation("org.testcontainers:testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")


}

tasks.findByName("check")!!.shouldRunAfter(":service-template-domain:check")

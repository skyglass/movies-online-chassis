plugins {
    id("TestReporter")
}


apply<IntegrationTestsPlugin>()
apply<RestAssuredTestDependenciesPlugin>()

dependencies {

    implementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-domain-security")
    implementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-util")
    implementation(project(":domain"))

    implementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-web-security")

    testImplementation("org.testcontainers:testcontainers")

    testImplementation(project(":web"))
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-health-check")
    testImplementation(project(":metrics"))

    testImplementation(project(":config"))
    testImplementation(project(":test-data"))
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-test-containers")
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-test-keycloak")
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-test-util")

}


tasks.findByName("check")!!.shouldRunAfter(":domain:check")

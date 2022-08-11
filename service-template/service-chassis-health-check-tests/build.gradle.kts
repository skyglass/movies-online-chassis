plugins {
    id("TestReporter")
}

apply<IntegrationTestsPlugin>()
apply<RestAssuredTestDependenciesPlugin>()

dependencies {
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-health-check")

    testImplementation(project(":domain"))
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-util")

    testImplementation(project(":persistence"))
    testImplementation(project(":test-data"))
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-test-containers")
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-test-util")

    runtimeOnly("mysql:mysql-connector-java")

}

tasks.findByName("check")!!.shouldRunAfter(":domain:check")

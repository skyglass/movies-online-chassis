plugins {
    id("TestReporter")
}

apply<IntegrationTestsPlugin>()
apply<RestAssuredTestDependenciesPlugin>()

dependencies {
    implementation(project(":domain"))

    implementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-util")
    implementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-metrics")


    testImplementation(project(":config"))
    testImplementation(project(":test-data"))

    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-test-util")
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-test-containers")
    testImplementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.testcontainers:testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")

}

tasks.findByName("check")!!.shouldRunAfter(":domain:check")

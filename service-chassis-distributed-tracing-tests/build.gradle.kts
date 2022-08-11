plugins {
    id("TestReporter")
}

apply<IntegrationTestsPlugin>()
apply<RestAssuredTestDependenciesPlugin>()

dependencies {

    implementation(project(":service-chassis-distributed-tracing"))

    testImplementation(project(":service-template-domain"))
    testImplementation(project(":service-template-web"))
    testImplementation(project(":service-chassis-util"))
    testImplementation(project(":service-chassis-test-util"))

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(project(":service-chassis-test-containers"))

}

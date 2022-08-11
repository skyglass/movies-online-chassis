apply<IntegrationTestsPlugin>()
apply<RestAssuredTestDependenciesPlugin>()

dependencies {

    implementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-util")
    implementation(project(":domain"))

    implementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-web")


    testImplementation(project(":test-data"))
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-test-containers")

}

tasks.findByName("check")!!.shouldRunAfter(":domain:check")

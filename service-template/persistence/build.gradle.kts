apply<IntegrationTestsPlugin>()

dependencies {

    implementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-persistence")
    implementation(project(":domain"))
    implementation(project(":config"))

    testImplementation(project(":test-data"))
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-test-containers")


}

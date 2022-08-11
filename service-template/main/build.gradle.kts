plugins {
    id("TestReporter")
    id("io.spring.dependency-management")
    id("org.springframework.boot")
}

apply<IntegrationTestsPlugin>()

apply<ComponentTestsPlugin>()

apply<RestAssuredTestDependenciesPlugin>()

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
    layered {
        isEnabled = true
    }
}


dependencies {

    implementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-util")
    implementation(project(":domain"))
    implementation(project(":config"))
    implementation(project(":persistence"))
    implementation(project(":web"))
    implementation(project(":web-security"))
    implementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-distributed-tracing")

    implementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-health-check")

    implementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-web-swagger")

    implementation(project(":metrics"))

    implementation("org.springframework.boot:spring-boot-devtools")

    implementation("org.springdoc:springdoc-openapi-ui")


    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-test-util")
    testImplementation(project(":test-data"))
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-test-containers")
    testImplementation("net.chrisrichardson.liveprojects.servicechassis:service-chassis-test-keycloak")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("org.testcontainers:testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:selenium")
    testImplementation("org.seleniumhq.selenium:selenium-remote-driver")
    testImplementation("org.seleniumhq.selenium:selenium-chrome-driver")

}


val integrationTest = tasks.findByName("integrationTest")!! as Test

integrationTest.apply {
    this.excludes.add("**/SwaggerUITests*")
}

tasks.register("testSwaggerUI", Test::class) {
    this.includes.add("**/SwaggerUITests*")
    testClassesDirs = integrationTest.testClassesDirs
    classpath = integrationTest.classpath

}

val checkTask = tasks.findByName("check")!!

checkTask.shouldRunAfter(":domain:check")
checkTask.shouldRunAfter(":web:check")
checkTask.shouldRunAfter(":web-security:check")
checkTask.shouldRunAfter(":persistence:check")
checkTask.shouldRunAfter(":metrics:check")


tasks.register("validateEnvironment", DefaultTask::class) {
    dependsOn("integrationTest")
}

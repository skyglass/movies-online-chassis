



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

    implementation(project(":service-chassis-util"))
    implementation(project(":service-template-domain"))
    implementation(project(":service-template-config"))
    implementation(project(":service-template-persistence"))
    implementation(project(":service-template-web"))
    implementation(project(":service-template-web-security"))
    implementation(project(":service-chassis-distributed-tracing"))

    implementation(project(":service-chassis-health-check"))
    implementation(project(":service-template-metrics"))

    implementation("org.springframework.boot:spring-boot-devtools")

    implementation(project(":service-chassis-web-swagger"))


    testImplementation(project(":service-chassis-test-util"))
    testImplementation(project(":service-template-test-data"))
    testImplementation(project(":service-chassis-test-containers"))
    testImplementation(project(":service-chassis-test-keycloak"))

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

checkTask.shouldRunAfter(":service-template-domain:check")
checkTask.shouldRunAfter(":service-template-web:check")
checkTask.shouldRunAfter(":service-template-web-security:check")
checkTask.shouldRunAfter(":service-template-persistence:check")
checkTask.shouldRunAfter(":service-template-metrics:check")
checkTask.shouldRunAfter(":service-chassis-health-check:check")
checkTask.shouldRunAfter(":service-chassis-distributed-tracing:check")


tasks.register("validateEnvironment", DefaultTask::class) {
    dependsOn("integrationTest")
}

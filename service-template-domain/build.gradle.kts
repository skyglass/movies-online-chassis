

apply<IntegrationTestsPlugin>()

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}

dependencies {

    implementation(project(":service-chassis-domain-security"))

    api("org.springframework.data:spring-data-commons")
    compileOnly("org.springframework.boot:spring-boot-starter-data-jpa")

    testImplementation(project(":service-template-test-data"))

}

tasks.register("validateEnvironment", DefaultTask::class) {
    dependsOn("test")
    dependsOn("integrationTest")
}

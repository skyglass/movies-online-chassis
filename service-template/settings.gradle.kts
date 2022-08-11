rootProject.name = "live-projects-service-template"


include("test-data")

include("domain")

include("config")
include("persistence")
include("web")
include("web-security")
include("service-chassis-health-check-tests")
include("metrics")
include("service-chassis-distributed-tracing-tests")

include("main")

pluginManagement {
    repositories {
        maven {
             url = uri(File(rootDir, "../build/repository"))
        }
    }
}

rootProject.name = "live-projects-service-template"


include("test-data")

include("domain")

include("config")
include("persistence")
include("web")
include("web-security")
include("metrics")

include("main")

pluginManagement {
    repositories {
        maven {
          url = uri("https://maven.pkg.github.com/skyglass/movies-online-chassis")
          if (System.getenv("MAVEN_REPO_USERNAME") != null)
            credentials {
                username = System.getenv("MAVEN_REPO_USERNAME")
                password = System.getenv("MAVEN_REPO_PASSWORD")
            }
        }
    }
}

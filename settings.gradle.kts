rootProject.name = "live-projects-service-template"

include("service-chassis-dependencies-bom")

include("service-chassis-util")

include("service-chassis-test-keycloak")
include("service-chassis-test-util")
include("service-template-test-data")
include("service-chassis-test-containers")

include("service-template-domain")
include("service-chassis-domain-security")

include("service-template-config")
include("service-chassis-persistence")
include("service-template-persistence")
include("service-chassis-web")
include("service-chassis-web-swagger")

include("service-template-web")
include("service-chassis-web-security")
include("service-template-web-security")
include("service-chassis-health-check")
include("service-chassis-health-check-tests")
include("service-chassis-metrics")
include("service-template-metrics")
include("service-chassis-distributed-tracing")
include("service-chassis-distributed-tracing-tests")

include("service-template-main")

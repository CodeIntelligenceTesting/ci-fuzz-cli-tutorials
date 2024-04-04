pluginManagement {
	repositories {
		maven {
			name = "CodeIntelligenceRepository"
			url = uri("https://gitlab.code-intelligence.com/api/v4/projects/89/packages/maven")
			credentials {
				username = extra["CodeIntelligenceRepositoryUsername"].toString()
				password = extra["CodeIntelligenceRepositoryPassword"].toString()
			}
			content {
				includeGroupByRegex("com\\.code-intelligence.*")
			}
		}
		gradlePluginPortal()
	}
}

include("app")
include("testsuite")

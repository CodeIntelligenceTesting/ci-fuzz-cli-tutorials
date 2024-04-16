plugins {
	application
	id("org.jetbrains.kotlin.jvm") version "1.7.20"
	id("com.code-intelligence.cifuzz") version "1.17.0"
}

repositories {
	// Configure access to CI repository
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
	mavenCentral()
}

application {
	mainClass.set("MainKt")
}

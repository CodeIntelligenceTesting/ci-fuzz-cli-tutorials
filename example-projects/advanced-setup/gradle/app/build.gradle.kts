plugins {
	id("java-library")
	id("org.jetbrains.kotlin.jvm") version "1.7.20"
	id("com.code-intelligence.cifuzz") version "1.16.0"
}

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
	mavenCentral()
}

cifuzz {
	mainSourceSet.set(sourceSets.create("more"))
}

sourceSets {
	test {
		java {
			compileClasspath += sourceSets["more"].output
			runtimeClasspath += sourceSets["more"].output
			srcDir("src/test/java")
		}
	}
}

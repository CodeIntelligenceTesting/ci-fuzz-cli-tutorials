plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    id("java-library")
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

val fuzzTest = sourceSets.create("fuzzTest") {
	java {
		compileClasspath += project(":app").sourceSets["more"].output
		runtimeClasspath += project(":app").sourceSets["more"].output
		srcDir("src/fuzzTest/java")
	}
}

tasks.register<Test>(sourceSets["fuzzTest"].name) {
	classpath = fuzzTest.runtimeClasspath
	testClassesDirs = fuzzTest.output.classesDirs
	useJUnitPlatform()
}

cifuzz {
	testSourceSet.set(fuzzTest)
}

dependencies {
	"fuzzTestImplementation"(project(":app"))
}

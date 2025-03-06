plugins {
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    id("java-library")
    id("com.code-intelligence.cifuzz") version "1.23.2"
}

repositories {
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

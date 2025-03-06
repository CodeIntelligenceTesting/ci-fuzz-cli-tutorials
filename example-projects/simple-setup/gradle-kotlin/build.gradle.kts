plugins {
	application
	id("org.jetbrains.kotlin.jvm") version "1.7.20"
	id("com.code-intelligence.cifuzz") version "1.23.2"
}

repositories {
	mavenCentral()
}

application {
	mainClass.set("MainKt")
}

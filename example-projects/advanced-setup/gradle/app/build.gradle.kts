plugins {
	id("java-library")
	id("org.jetbrains.kotlin.jvm") version "1.7.20"
	id("com.code-intelligence.cifuzz") version "1.23.2"
}

repositories {
	mavenCentral()
}

cifuzz {
	mainSourceSet.set(sourceSets.create("more"))
}

dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
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

plugins {
    id("java")
    id("application")
    id("com.github.johnrengelman.shadow").version("8.1.1")
    id("com.adarshr.test-logger").version("4.0.0")
}

group = "com.xyphias"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.assertj:assertj-core:3.26.0")
    testImplementation("com.approvaltests:approvaltests:24.2.0")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(22)
    }
}

application {
    mainClass = "com.xyphias.trackpenpalreplies.Main"
}

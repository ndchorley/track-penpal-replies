plugins {
    id("java")
    id("application")
    id("com.gradleup.shadow").version("9.3.1")
    id("com.adarshr.test-logger").version("4.0.0")
}

group = "com.xyphias"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.xerial:sqlite-jdbc:3.51.2.0")
    implementation("org.flywaydb:flyway-core:12.0.0")
    
    val slf4JVersion = "2.0.17"
    implementation("org.slf4j:slf4j-api:$slf4JVersion")
    implementation("org.slf4j:slf4j-jdk14:$slf4JVersion")
    
    testImplementation(platform("org.junit:junit-bom:6.0.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("com.approvaltests:approvaltests:26.6.1")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

application {
    mainClass = "Main"
}

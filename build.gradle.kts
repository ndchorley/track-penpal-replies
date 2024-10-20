plugins {
    id("java")
    id("application")
    id("com.gradleup.shadow").version("8.3.2")
    id("com.adarshr.test-logger").version("4.0.0")
}

group = "com.xyphias"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.xerial:sqlite-jdbc:3.46.1.3")
    implementation("org.flywaydb:flyway-core:10.20.0")
    
    implementation("org.slf4j:slf4j-api:2.0.16")
    implementation("org.slf4j:slf4j-jdk14:2.0.16")
    
    testImplementation(platform("org.junit:junit-bom:5.11.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.assertj:assertj-core:3.26.3")
    testImplementation("com.approvaltests:approvaltests:24.8.0")
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

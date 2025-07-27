plugins {
    id("java")
    id("application")
    id("com.gradleup.shadow").version("8.3.8")
    id("com.adarshr.test-logger").version("4.0.0")
}

group = "com.xyphias"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.xerial:sqlite-jdbc:3.50.3.0")
    implementation("org.flywaydb:flyway-core:11.10.4")
    
    val slf4JVersion = "2.0.17"
    implementation("org.slf4j:slf4j-api:$slf4JVersion")
    implementation("org.slf4j:slf4j-jdk14:$slf4JVersion")
    
    testImplementation(platform("org.junit:junit-bom:5.13.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.assertj:assertj-core:3.27.3")
    testImplementation("com.approvaltests:approvaltests:24.22.0")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

application {
    mainClass = "com.xyphias.trackpenpalreplies.Main"
}

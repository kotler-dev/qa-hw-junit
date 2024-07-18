plugins {
    id("java")
}

group = "dev.kotler"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    version = 17
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.0-M2")
    testImplementation("com.codeborne:selenide:7.3.3")
}

tasks.test {
    useJUnitPlatform()
}
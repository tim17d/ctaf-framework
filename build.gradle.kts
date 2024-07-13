import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    java
    checkstyle
    id("io.freefair.lombok") version "8.6"
    id("io.qameta.allure") version "2.11.2"
}

group = "com.github.tim17d"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val agent: Configuration by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = true
}

dependencies {
    implementation("org.reflections:reflections:0.10.2")
    implementation("com.codeborne:selenide:7.1.0")
    implementation("io.rest-assured:rest-assured:5.4.0")
    implementation("com.zaxxer:HikariCP:5.1.0")
    implementation("org.springframework:spring-jdbc:6.1.10")
    /* H2 embedded database dependency is only for demo testing purpose.
    You can delete it and add other necessary connectors, e.g. PostgresSQL, MySQL, etc. */
    implementation("com.h2database:h2:2.2.224")
    implementation("ch.qos.logback:logback-core:1.5.0")
    implementation("ch.qos.logback:logback-classic:1.5.0")
    implementation(platform("io.qameta.allure:allure-bom:2.25.0"))
    implementation("io.qameta.allure:allure-junit5")
    agent("org.aspectj:aspectjweaver:1.9.21")
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("org.assertj:assertj-core:3.25.3")

}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.test {
    useJUnitPlatform {
        val tags = project.findProperty("tags") as String?
        if (!tags.isNullOrEmpty()) {
            includeTags(*tags.split(",").map { it.trim() }.toTypedArray())
        }
    }
    systemProperty("env", project.findProperty("env") ?: "test")
    testLogging.exceptionFormat = TestExceptionFormat.FULL
    testLogging.showStandardStreams = true
    jvmArgs = listOf(
            "-javaagent:${agent.singleFile}"
    )
    outputs.upToDateWhen { false }
}

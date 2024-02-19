plugins {
    java
    checkstyle
    id("io.freefair.lombok") version "8.6"
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
    implementation("com.codeborne:selenide:7.1.0")
    implementation("io.rest-assured:rest-assured:5.4.0")
    implementation("org.postgresql:postgresql:42.7.1")
    implementation("ch.qos.logback:logback-core:1.5.0")
    implementation("ch.qos.logback:logback-classic:1.5.0")
    implementation(platform("io.qameta.allure:allure-bom:2.25.0"))
    implementation("io.qameta.allure:allure-junit5")
    agent("org.aspectj:aspectjweaver:1.9.21")
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("org.assertj:assertj-core:3.25.3")

}

tasks.compileJava {
    options.release = 21
}

tasks.test {
    useJUnitPlatform()
    jvmArgs = listOf(
            "-javaagent:${agent.singleFile}"
    )
}

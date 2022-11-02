plugins {
    kotlin("jvm") version "1.7.20"
    id( "com.github.ben-manes.versions") version "0.43.0"
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "17"
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
    testImplementation("org.assertj:assertj-core:3.23.1")
    testImplementation("org.mockito:mockito-core:4.8.1")
    testImplementation("io.kotest:kotest-runner-junit5:5.5.3")
    testImplementation("io.kotest:kotest-assertions-core:5.5.3")
    // testImplementation("org.mockito:mockito-junit-jupiter:2.+")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs("--enable-preview")
    testLogging {
        events("passed", "skipped", "failed")
    }
}

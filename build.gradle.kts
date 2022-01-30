plugins {
    kotlin("jvm") version "1.6.10"
    id( "com.github.ben-manes.versions") version "0.41.0"
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

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    testImplementation("org.assertj:assertj-core:3.22.0")
    testImplementation("org.mockito:mockito-core:4.3.1")
    // testImplementation("org.mockito:mockito-junit-jupiter:2.+")
}

tasks.test {
    useJUnitPlatform()
    jvmArgs("--enable-preview")
    testLogging {
        events("passed", "skipped", "failed")
    }
}

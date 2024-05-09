
plugins {
    java
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)
    implementation(libs.jackson.core)
    implementation(libs.jackson.databind)
    implementation(libs.jackson.annotations)
    implementation(libs.dom4j)
    implementation(project(":lib"))
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

tasks.register("hello") {
    println("hello,world")
}

tasks.register<Copy>("copy-github") {
    from("../.github/workflowsbackup/gradle.yml")
    into("src/main/resources")
    include("*.*")
    dependsOn("hello")
}

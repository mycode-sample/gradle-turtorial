plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    java
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenLocal()
    maven { setUrl("https://maven.aliyun.com/repository/public") }
}

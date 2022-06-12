apply(plugin = "org.springframework.boot")
apply(plugin = "kotlin-spring")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.apache.kafka:kafka-clients:2.8.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

extra.apply {
    set("groovy.version", "3.0.7")
}

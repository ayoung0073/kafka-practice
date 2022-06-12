import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply(plugin = "org.springframework.boot")
apply(plugin = "kotlin-spring")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.apache.kafka:kafka-clients:2.8.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka:3.2.4")
    implementation("org.springframework.cloud:spring-cloud-stream:3.2.4")
}
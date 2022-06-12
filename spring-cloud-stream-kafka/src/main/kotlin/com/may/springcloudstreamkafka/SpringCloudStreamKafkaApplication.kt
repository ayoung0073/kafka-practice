package com.may.springcloudstreamkafka

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCloudStreamKafkaApplication

fun main(args: Array<String>) {
    val applicationContext = runApplication<SpringCloudStreamKafkaApplication>(*args)
    val producer =  applicationContext.getBean("kafkaTestProducer") as KafkaTestProducer
    producer.send("hi")
}

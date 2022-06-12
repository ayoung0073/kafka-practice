package com.may.springkafka.consumer

import com.may.springkafka.Constant
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer

import java.time.Duration

fun main() {
    val consumer: KafkaConsumer<String, String> = KafkaConsumer(CustomConsumerConfig.get())
    consumer.subscribe(listOf(Constant.TOPIC_NAME))
    while (true) {
        val records: ConsumerRecords<String, String> = consumer.poll(Duration.ofSeconds(1))
        for (record in records) {
            println(record.value())
        }
    }
}

package com.may.springkafka.consumer

import com.may.springkafka.Constant
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer

import java.time.Duration

fun main() {
    val configs = CustomConsumerConfig.get()
    configs[ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG] = false

    val consumer: KafkaConsumer<String, String> = KafkaConsumer(configs)
    consumer.subscribe(listOf(Constant.TOPIC_NAME))

    while (true) {
        val records: ConsumerRecords<String, String> = consumer.poll(Duration.ofSeconds(1))
        for (record in records) {
            println(record.value())
            consumer.commitSync()
            println(record.offset())
        }
    }
}
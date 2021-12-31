package com.may.kafkapractice.consumer

import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer

import java.time.Duration
import java.util.*

private const val TOPIC_NAME = "test-topic"
private const val GROUP_ID = "testgroup"
private const val BOOTSTRAP_SERVERS = "127.0.0.1:9092"

fun main() {
    val configs = Properties()
    configs[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = BOOTSTRAP_SERVERS
    configs[ConsumerConfig.GROUP_ID_CONFIG] = GROUP_ID
    configs[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name
    configs[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name
    val consumer: KafkaConsumer<String, String> = KafkaConsumer(configs)
    consumer.subscribe(listOf(TOPIC_NAME))
    while (true) {
        val records: ConsumerRecords<String, String> = consumer.poll(Duration.ofSeconds(1))
        for (record in records) {
            println(record.value())
        }
    }
}

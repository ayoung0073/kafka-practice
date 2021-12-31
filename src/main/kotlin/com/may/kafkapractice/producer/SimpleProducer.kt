package com.may.kafkapractice.producer

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer

import java.lang.Exception
import java.util.*

private const val TOPIC_NAME = "test-topic"

private const val BOOTSTRAP_SERVERS = "127.0.0.1:9092"

fun main() {
    val configs = Properties()
    configs[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = BOOTSTRAP_SERVERS
    configs[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
    configs[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
    val producer: KafkaProducer<String, String> = KafkaProducer(configs)
    for (index in 0..9) {
        val data = "This is record $index"
        val record = ProducerRecord<String, String>(TOPIC_NAME, data)
        try {
            producer.send(record)
            println("Send to $TOPIC_NAME | data : $data")
            Thread.sleep(1000)
        } catch (e: Exception) {
            println(e)
        }
    }
}

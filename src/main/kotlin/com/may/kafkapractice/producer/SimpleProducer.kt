package com.may.kafkapractice.producer

import com.may.kafkapractice.Constant
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer

import java.lang.Exception
import java.util.*

fun main() {
    val configs = Properties()
    configs[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = Constant.BOOTSTRAP_SERVERS
    configs[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
    configs[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
    val producer: KafkaProducer<String, String> = KafkaProducer(configs)
    for (index in 0..9) {
        val data = "This is record $index"
        val record = ProducerRecord<String, String>(Constant.TOPIC_NAME, data)
        try {
            producer.send(record)
            println("Send to $Constant.TOPIC_NAME | data : $data")
            Thread.sleep(1000)
        } catch (e: Exception) {
            println(e)
        }
    }
}

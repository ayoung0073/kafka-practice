package com.may.kafkapractice.producer

import com.may.kafkapractice.Constant
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import java.lang.Exception

fun main() {
    val producer: KafkaProducer<String, String> = KafkaProducer(CustomProducerConfig.get())
    repeat(2) {
        for (index in 0..9) {
            val data = "This is record $index"
            val record = ProducerRecord(Constant.TOPIC_NAME, index.toString(), data)
            try {
                producer.send(record)
                println("Send to $Constant.TOPIC_NAME | data : $data")
                Thread.sleep(1000)
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}
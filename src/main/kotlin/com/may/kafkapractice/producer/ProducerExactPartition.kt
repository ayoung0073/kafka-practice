package com.may.kafkapractice.producer

import com.may.kafkapractice.Constant
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord

import java.lang.Exception

/*
전송하는 메시지에 키를 지정하면 원하는 파티션으로 전송되게 된다.

bin/kafka-console-producer.sh --bootstrap-server localhost:9092
--topic [토픽 이름]
--property "parse.key=true" --property "key.separator=:"
*/

private const val PARTITION_NUMBER = 1

fun main() {
    val producer: KafkaProducer<String, String> = KafkaProducer(CustomProducerConfig.get())
    for (index in 0..9) {
        val data = "This is record $index"
        val record = ProducerRecord(Constant.TOPIC_NAME, PARTITION_NUMBER, index.toString(), data)
        try {
            producer.send(record)
            println("Send to $Constant.TOPIC_NAME | data : $data")
            Thread.sleep(1000)
        } catch (e: Exception) {
            println(e)
        }
    }
}
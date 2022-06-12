package com.may.springkafka.producer

import com.may.springkafka.Constant
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import java.util.*

class CustomProducerConfig {
    companion object {
        fun get(): Properties {
            val configs = Properties()
            configs[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = Constant.BOOTSTRAP_SERVERS
            configs[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
            configs[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java.name
            return configs
        }
    }
}
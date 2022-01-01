package com.may.kafkapractice.consumer

import com.may.kafkapractice.Constant
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import java.util.*

class CustomConsumerConfig {
    companion object {
        fun get(): Properties {
            val configs = Properties()
            configs[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = Constant.BOOTSTRAP_SERVERS
            configs[ConsumerConfig.GROUP_ID_CONFIG] = Constant.GROUP_ID
            configs[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name
            configs[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name
            return configs
        }
    }
}
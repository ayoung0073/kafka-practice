package com.may.springcloudstreamkafka

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import java.util.function.Consumer

@Component
class KafkaTestConsumer {
    @Bean
    fun testEvent(): Consumer<String> {
        return Consumer { event ->
            println("event message")
            println(event)
        }
    }
}
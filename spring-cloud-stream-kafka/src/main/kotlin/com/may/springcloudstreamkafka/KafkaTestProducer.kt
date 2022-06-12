package com.may.springcloudstreamkafka

import org.springframework.cloud.stream.function.StreamBridge
import org.springframework.stereotype.Component

@Component
class KafkaTestProducer(
    private val stringBridge: StreamBridge
) {
    fun send(payload: String) {
        stringBridge.send("testEvent-out-0", payload)
    }
}
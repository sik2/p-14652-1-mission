package com.back.infra.kafka;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("test")
@EmbeddedKafka // 임베디드 Kafka를 사용한다
@SpringBootTest
public class KafkaTest {
    @Autowired
    private MyEventListener listener;
    @Autowired
    private KafkaTemplate<String, MyEvent> kafkaTemplate;

    @Test
    @DisplayName("kafka-test01")
    void t001() throws InterruptedException{
        MyEvent myEvent = new MyEvent("hello kafka");
        kafkaTemplate.send(myEvent.getEventName(), myEvent);

        boolean received = listener.getLatch().await(10, TimeUnit.SECONDS);

        assertThat(received).isTrue();
        assertThat(listener.getReceivedEvent().msg()).isEqualTo("hello kafka");
    }


}

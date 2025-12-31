package ai.shago.kafkaplayground.global;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import ai.shago.kafkaplayground.standard.event.HaveEventName;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventPublisher {
	private final KafkaTemplate<String, HaveEventName> kafkaTemplate;

	public void publish(HaveEventName event) {
		kafkaTemplate.send(event.getEventName(), event);
	}
}

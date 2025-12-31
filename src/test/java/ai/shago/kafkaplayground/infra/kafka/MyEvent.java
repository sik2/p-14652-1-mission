package ai.shago.kafkaplayground.infra.kafka;

import ai.shago.kafkaplayground.standard.event.HaveEventName;

public record MyEvent(String msg) implements HaveEventName {
}

package ai.shago.shared.member.event;

import ai.shago.kafkaplayground.standard.event.HaveEventName;
import ai.shago.shared.member.dto.MemberDto;

public record MemberJoinedEvent(
	MemberDto member
) implements HaveEventName {
}

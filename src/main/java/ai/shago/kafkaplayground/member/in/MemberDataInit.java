package ai.shago.kafkaplayground.member.in;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ai.shago.kafkaplayground.global.EventPublisher;
import ai.shago.shared.member.dto.MemberDto;
import ai.shago.shared.member.event.MemberJoinedEvent;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MemberDataInit {
	private final EventPublisher eventPublisher;

	@Bean
	public ApplicationRunner memberDataInitApplicationRunner() {
		return args -> {
			eventPublisher.publish(
				new MemberJoinedEvent(
					new MemberDto(1)
				)
			);
		};
	}
}

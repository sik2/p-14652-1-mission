package com.back.shared.event;

import com.back.shared.dto.MemberDto;
import com.back.standard.event.HasEventName;

public record MemberJoinedEvent(
        MemberDto memberDto
) implements HasEventName { }

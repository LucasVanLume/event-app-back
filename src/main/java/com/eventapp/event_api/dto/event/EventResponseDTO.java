package com.eventapp.event_api.dto.event;

import com.eventapp.event_api.domain.event.Event;
import java.util.UUID;

public record EventResponseDTO(
        UUID id,
        String title,
        String description,
        String imgUrl,
        String eventUrl,
        String startTime,
        String endTime,
        String date,
        String theme,
        String email,
        String phone,
        Boolean remote,
        String userId) {

    public EventResponseDTO(Event event) {
        this(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getImgUrl(),
                event.getEventUrl(),
                event.getStartTime(),
                event.getEndTime(),
                event.getDate(),
                event.getTheme(),
                event.getEmail(),
                event.getPhone(),
                event.getRemote(),
                event.getUser().getId()
        );
    }
}


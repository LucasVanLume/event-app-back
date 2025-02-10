package com.eventapp.event_api.dto.event;

import java.util.List;

public record PageEventResponseDTO(List<EventResponseDTO> events, long totalElements, int totalPages) {

}

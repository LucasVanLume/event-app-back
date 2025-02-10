package com.eventapp.event_api.dto.event;

public record EventRequestDTO(
        String title,
        String description,
        String imgUrl,
        String eventUrl,
        String startTime,
        String endTime,
        String startDate,
        String endDate,
        String theme,
        String email,
        String phone,
        Boolean remote,
        AddressRequestDTO address) { }

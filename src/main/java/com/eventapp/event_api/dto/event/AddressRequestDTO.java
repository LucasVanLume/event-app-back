package com.eventapp.event_api.dto.event;

public record AddressRequestDTO(
        String cep,
        String street,
        String city,
        String neighborhood
) {}


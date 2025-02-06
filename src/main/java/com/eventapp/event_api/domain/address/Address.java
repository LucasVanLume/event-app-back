package com.eventapp.event_api.domain.address;

import com.eventapp.event_api.domain.event.Event;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "address")
@Entity
public class Address {
    @Id
    @GeneratedValue
    private UUID id;

    private String cep;
    private String street;
    private String city;
    private String neighborhood;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}

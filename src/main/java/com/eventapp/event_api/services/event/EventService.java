package com.eventapp.event_api.services.event;

import com.eventapp.event_api.domain.event.Event;
import com.eventapp.event_api.domain.event.EventDateConverter;
import com.eventapp.event_api.domain.user.User;
import com.eventapp.event_api.dto.event.EventRequestDTO;
import com.eventapp.event_api.dto.event.EventResponseDTO;
import com.eventapp.event_api.dto.event.PageEventResponseDTO;
import com.eventapp.event_api.infra.security.UserDetailsService;
import com.eventapp.event_api.repositories.EventRepository;
import com.eventapp.event_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsService userDetailsService;

    public Event createEvent(EventRequestDTO data) {
        User user = userDetailsService.getAuthenticatedUser();

        Event newEvent = new Event();

        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setImgUrl(data.imgUrl());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setStartTime(data.startTime());
        newEvent.setEndTime(data.endTime());
        newEvent.setStartDate(EventDateConverter.convertStringToLocalDate(data.startDate()));
        newEvent.setEndDate(EventDateConverter.convertStringToLocalDate(data.endDate()));
        newEvent.setRemote(data.remote());
        newEvent.setTheme(data.theme());
        newEvent.setEmail(data.email());
        newEvent.setPhone(data.phone());
        newEvent.setUser(user);

        eventRepository.save(newEvent);
        return newEvent;
    }

    public PageEventResponseDTO getAllEvents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Event> eventsPage = this.eventRepository.findUpcomingEvents(LocalDate.now(), pageable);

        long totalEvents = this.eventRepository.countUpcomingEvents(LocalDate.now());

        return new PageEventResponseDTO(
                eventsPage.map(EventResponseDTO::new).stream().toList(),
                totalEvents,
                (int) Math.ceil((double) totalEvents / size)
        );
    }
}

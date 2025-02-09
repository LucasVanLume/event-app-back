package com.eventapp.event_api.services.event;

import com.eventapp.event_api.domain.event.Event;
import com.eventapp.event_api.domain.event.EventDateConverter;
import com.eventapp.event_api.domain.user.User;
import com.eventapp.event_api.dto.event.EventRequestDTO;
import com.eventapp.event_api.infra.security.UserDetailsService;
import com.eventapp.event_api.repositories.EventRepository;
import com.eventapp.event_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
/*        newEvent.setStartDate(data.startDate());
        newEvent.setEndDate(data.endDate());*/
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

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
}

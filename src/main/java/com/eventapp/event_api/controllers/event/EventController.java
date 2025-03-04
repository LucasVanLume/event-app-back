package com.eventapp.event_api.controllers.event;

import com.eventapp.event_api.domain.event.Event;
import com.eventapp.event_api.dto.event.EventRequestDTO;
import com.eventapp.event_api.dto.event.EventResponseDTO;
import com.eventapp.event_api.dto.event.PageEventResponseDTO;
import com.eventapp.event_api.services.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<Event> create(@RequestBody EventRequestDTO body,
                                        @AuthenticationPrincipal UserDetails userDetails) {
        Event newEvent = this.eventService.createEvent(body);
        return ResponseEntity.ok(newEvent);
    }

    @GetMapping("/events")
    public ResponseEntity<PageEventResponseDTO> getAllEvents(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        PageEventResponseDTO eventPage = this.eventService.getAllEvents(page, size);
        return ResponseEntity.ok(eventPage);
    }
}

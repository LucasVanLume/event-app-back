package com.eventapp.event_api.repositories;

import com.eventapp.event_api.domain.event.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
    @Query("SELECT e FROM Event e WHERE e.endDate >= :currentDate ORDER BY e.startDate ASC")
    public Page<Event> findUpcomingEvents(@Param("currentDate") LocalDate currentDate, Pageable pageable);

    @Query("SELECT COUNT(e) FROM Event e WHERE e.endDate >= :currentDate")
    public long countUpcomingEvents(@Param("currentDate") LocalDate currentDate);
}

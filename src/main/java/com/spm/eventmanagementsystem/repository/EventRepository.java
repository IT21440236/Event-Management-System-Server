package com.spm.eventmanagementsystem.repository;

import com.spm.eventmanagementsystem.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    Optional<Event> findEventByEventCode(String eventCode);

    void deleteEventByEventCode(String eventCode);
}

package com.spm.eventmanagementsystem.service;

import com.spm.eventmanagementsystem.dto.EventDTO;
import com.spm.eventmanagementsystem.dto.UserDTO;
import com.spm.eventmanagementsystem.entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {
//    public Event addEvent(EventDTO eventDTO);

    //CREATE
    public EventDTO addEvent(EventDTO eventDTO);

    //RETRIEVE
    public List<EventDTO> getAllEvents();

    //UPDATE
    public EventDTO updateEvent(EventDTO eventDTO);

    //DELETE
    public boolean deleteEvent(EventDTO eventDTO);
}

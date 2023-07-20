package com.spm.eventmanagementsystem.service;

import com.spm.eventmanagementsystem.dto.EventDTO;
import com.spm.eventmanagementsystem.dto.UserDTO;
import com.spm.eventmanagementsystem.entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {
//    public Event addEvent(EventDTO eventDTO);
    public EventDTO addEvent(EventDTO eventDTO);

    public List<EventDTO> getAllEvents();
}

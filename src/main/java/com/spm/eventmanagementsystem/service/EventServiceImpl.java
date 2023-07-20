package com.spm.eventmanagementsystem.service;

import com.spm.eventmanagementsystem.dto.EventDTO;
import com.spm.eventmanagementsystem.dto.UserDTO;
import com.spm.eventmanagementsystem.entity.Event;
import com.spm.eventmanagementsystem.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;
//    @Override
//    public Event addEvent(EventDTO eventDTO) {
//        Event event = new Event();
//        event.setEventId(eventDTO.getEventId());
//        event.setEventCode(eventDTO.getEventCode());
//        event.setEventName(eventDTO.getEventName());
//        event.setDate(eventDTO.getDate());
//        event.setTime(eventDTO.getTime());
//        event.setVenue(eventDTO.getVenue());
//        event.setDescription(eventDTO.getDescription());
//        event.setOrganizer(eventDTO.getOrganizer());
//        event.setCategory(eventDTO.getCategory());
//        event.setGuestCount(eventDTO.getGuestCount());
//        event.setStatus(eventDTO.getStatus());
//        eventRepository.save(event);
//        return event;
//    }
    @Override
    public EventDTO addEvent(EventDTO eventDTO) {
        eventRepository.save(modelMapper.map(eventDTO, Event.class));
        return eventDTO;
    }

    @Override
    public List<EventDTO> getAllEvents() {
        List<Event> eventList = eventRepository.findAll();
        return modelMapper.map(eventList, new TypeToken<List<EventDTO>>(){}.getType());
    }
}

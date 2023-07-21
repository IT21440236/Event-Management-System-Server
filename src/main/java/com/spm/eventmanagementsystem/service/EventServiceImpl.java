package com.spm.eventmanagementsystem.service;

import com.spm.eventmanagementsystem.dto.EventDTO;
import com.spm.eventmanagementsystem.dto.UserDTO;
import com.spm.eventmanagementsystem.entity.Event;
import com.spm.eventmanagementsystem.exception.ResourceNotFoundException;
import com.spm.eventmanagementsystem.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;

/*=======================================================*/
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
/*=======================================================*/


    /*U can see how we can reduce boilerplate code with modelmapper dependency*/

    //CREATE
    @Override
    public EventDTO addEvent(EventDTO eventDTO) {
        eventRepository.save(modelMapper.map(eventDTO, Event.class));
        return eventDTO;
    }

    //RETRIEVE - All Events
    @Override
    public List<EventDTO> getAllEvents() {
        List<Event> eventList = eventRepository.findAll();
        return modelMapper.map(eventList, new TypeToken<List<EventDTO>>(){}.getType());
    }

    //RETRIEVE - Single Event
    @Override
    public Optional<EventDTO> getSingleEvent(String eventCode) {
        Optional<Event> event = eventRepository.findEventByEventCode(eventCode);
        return modelMapper.map(event, new TypeToken<Optional<EventDTO>>(){}.getType());
    }

//public Optional<EventDTO> getSingleEvent(String eventCode) {
//    Optional<Event> event = eventRepository.findEventByEventCode(eventCode);
//
//    if (event.isPresent()) {
//        return modelMapper.map(event, new TypeToken<Optional<EventDTO>>(){}.getType());
//    } else {
//        throw new ResourceNotFoundException("Event not exist with eventCode: " + eventCode);
//    }
//}


//    @Override
//    public Optional<EventDTO> getSingleEvent(String eventCode) throws ResourceNotFoundException {
//        Event event = eventRepository.findEventByEventCode(eventCode)
//                .orElseThrow(() -> new ResourceNotFoundException("Event not found with code: " + eventCode));
//        return modelMapper.map(event, new TypeToken<Optional<EventDTO>>(){}.getType());
//    }



    //UPDATE
    @Override
    public EventDTO updateEvent(EventDTO eventDTO){
        eventRepository.save(modelMapper.map(eventDTO, Event.class));
        return eventDTO;
    }


    //DELETE
    @Override
    public boolean deleteEvent(EventDTO eventDTO) {
//        eventRepository.deleteAll();
        eventRepository.delete(modelMapper.map(eventDTO, Event.class));
        return true;
    }
}

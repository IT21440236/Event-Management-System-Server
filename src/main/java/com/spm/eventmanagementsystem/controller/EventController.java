package com.spm.eventmanagementsystem.controller;

import com.spm.eventmanagementsystem.dto.EventDTO;
import com.spm.eventmanagementsystem.entity.Event;
import com.spm.eventmanagementsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/event")
@CrossOrigin
public class EventController {

    @Autowired
    private EventService eventService;

/*==================================================================*/
//    @PostMapping("/add")
//    public String addEvent(@RequestBody EventDTO eventDTO){
//        String id = eventService.addEvent(eventDTO);
//        return id;
//    }
//    public Event addEvent(@RequestBody EventDTO eventDTO){
//        Event event = eventService.addEvent(eventDTO);
//        return event;
//    }
/*==================================================================*/


    @PostMapping("/add")
    public EventDTO addEvent(@RequestBody EventDTO eventDTO){
        return eventService.addEvent(eventDTO);
    }

    @GetMapping("/get")
    public List<EventDTO> getEvents(){
        return eventService.getAllEvents();
    }

    @PutMapping("/get")
    public EventDTO updateEvent(@RequestBody EventDTO eventDTO){
        return eventService.updateEvent(eventDTO);
    }

    @DeleteMapping("/delete")
    public boolean deleteEvent(EventDTO eventDTO){
        return eventService.deleteEvent(eventDTO);
    }
}

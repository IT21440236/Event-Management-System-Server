package com.spm.eventmanagementsystem.controller;

import com.spm.eventmanagementsystem.dto.EventDTO;
import com.spm.eventmanagementsystem.entity.Event;
import com.spm.eventmanagementsystem.exception.ResourceNotFoundException;
import com.spm.eventmanagementsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    //CREATE
    @PostMapping("/add")
    public EventDTO addEvent(@RequestBody EventDTO eventDTO){
        return eventService.addEvent(eventDTO);
    }

    //RETRIEVE
    @GetMapping("/get")
    public ResponseEntity<List<EventDTO>> getEvents(){
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);

    }
/*======================================*/
//    public List<EventDTO> getEvents(){
//        return eventService.getAllEvents();
//    }
/*======================================*/

//    @GetMapping("/get/{eventCode}")
//    ResponseEntity<Optional<EventDTO>> getSingleEvent(@PathVariable String eventCode){
//        return new ResponseEntity<>(eventService.getSingleEvent(eventCode), HttpStatus.OK);
//    }

    @GetMapping("/get/{eventCode}")
    public ResponseEntity<Optional<EventDTO>> getSingleEvent(@PathVariable String eventCode) {
        try {
            Optional<EventDTO> event = eventService.getSingleEvent(eventCode);

            if (event.isPresent()) {
                return new ResponseEntity<>(event, HttpStatus.OK);
            } else {
                // Return 404 Not Found if the event is not found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (ResourceNotFoundException e) {
            // Handle the ResourceNotFoundException thrown by the service layer
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Handle other unexpected exceptions
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //UPDATE
    @PutMapping("/get")
    public EventDTO updateEvent(@RequestBody EventDTO eventDTO){
        return eventService.updateEvent(eventDTO);
    }

    //UPDATE - using eventCode
    @PutMapping("/get/{eventCode}")
    public ResponseEntity<Optional<EventDTO>> updateEventByEventCode(@PathVariable String eventCode,
                                                                     @RequestBody EventDTO eventDTO){

        try{
            Optional<EventDTO> event = eventService.updateEventByEventCode(eventDTO, eventCode);

            if (event.isPresent()) {
                return new ResponseEntity<>(event, HttpStatus.OK);
            } else {
                // Return 404 Not Found if the event is not found
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (ResourceNotFoundException e) {
            // Handle the ResourceNotFoundException thrown by the service layer
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Handle other unexpected exceptions
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    //DELETE - All Events
    @DeleteMapping("/delete")
    public ResponseEntity<EventDTO> deleteAllEvents(){
        eventService.deleteAllEvents();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //DELETE - Single Event using eventId
    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<Void> deleteEventByEventCode(@PathVariable int eventId){
        eventService.deleteEvent(eventId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //Deleting using eventCode, tried not working --> Check.
    //Just writing the method name in repo didnt work.
    //Build the logic for it.
}

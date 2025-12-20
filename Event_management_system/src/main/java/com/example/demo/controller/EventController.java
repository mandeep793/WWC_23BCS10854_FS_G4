package com.example.demo.controller;
import com.example.demo.model.Event;

import com.example.demo.service.EventService; //to use business logic present in service layer
import org.springframework.web.bind.annotation.*;//to create rest controller means to handle http requests 
import org.springframework.http.HttpStatus; //to send status code in response
import org.springframework.http.ResponseEntity; //to get response means status code along with data

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/events") //base url for all endpoints in this controller (all APIs have this as base url) //port in spring boot is 8080 by default
public class EventController {
    private final EventService eventService;
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping //endpoint to fetch all events
    public ResponseEntity<List<Event>> getAllEvents(){
        return ResponseEntity.ok(eventService.getAllEvents());// response with status code 200 along with list of events
        //.ok() means status code 200
    }

    @GetMapping("/{id}") //fetching id from particular event
    public ResponseEntity<Event> getEventbyId(int id){
        Event event=eventService.getEventbyId(id);
        if(event!=null){
            return ResponseEntity.ok(event);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }

    
    //HOMEWORK --- CREATE ALL ENDPOINTS AND TEST ON POSTMAN
    //testing an API on postman 
    //Steps involved:
    //1. Create a new request
    //2. Select the HTTP method (GET, POST, PUT, DELETE, etc.)
    //3. Enter the URL of the API endpoint like here to test already created getall events and get event by id we use url as http://localhost:8080/events
    //
    
}

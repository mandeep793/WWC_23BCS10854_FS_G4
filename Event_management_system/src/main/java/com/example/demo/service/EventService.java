package com.example.demo.service; 
import com.example.demo.model.Event;

import java.util.ArrayList;
import java.util.List; //good practice to include parent pacakge also 

public class EventService {
    //contains business logic for event management
    private List<Event> events=new ArrayList<>();

    public List<Event> getAllEvents(){
        return events;
    }

    public Event getEventbyId(int id){
        return events.stream()
         .filter(Event->Event.getId()==id)
         .findFirst().orElse(null);
    }

    public Event addEvent(Event event){
        events.add(event);
        return event;
    }
    public Event deleteEvent(int id){
        Event event=getEventbyId(id);
        if(event!=null){
            events.remove(event);
            return event;
        }
        return event;
    }
}

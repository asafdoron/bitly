package com.forwrd.bitly.service;



import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.forwrd.bitly.entity.Event;
import com.forwrd.bitly.repository.EventRepository;


@Service
public class EventService {
    
    @Autowired
    EventRepository eventRepository;

    // getting all Event records
    public List<Event> getAllEvent() {
        List<Event> events = new ArrayList<Event>();
        eventRepository.findAll().forEach(event -> events.add(event));
        return events;
    }

    // // getting a specific record
    // public Event getEventById(String id) {
    //     return eventRepository.findById(id).get();
    // }

    public void saveOrUpdate(Event event) {
        eventRepository.save(event);
    }

  

}

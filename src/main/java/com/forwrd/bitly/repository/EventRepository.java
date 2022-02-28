package com.forwrd.bitly.repository;

import org.springframework.data.repository.CrudRepository;
import com.forwrd.bitly.entity.*;



public interface EventRepository extends CrudRepository<Event, Long>
{
    
}




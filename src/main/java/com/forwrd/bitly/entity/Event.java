package com.forwrd.bitly.entity;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//mark class as an Entity 
@Entity
// defining class name as Table name
@Table
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String userId;

    @Column
    private String shortUrl;

    @Column
    private Timestamp redirectDate;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getuserId() {
        return userId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }

    public String getshortUrl() {
        return shortUrl;
    }

    public void setshortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }



    public Timestamp getredirectDate() {
        return redirectDate;
    }

    public void setredirectDate(Timestamp redirectDate) {
        this.redirectDate = redirectDate;
    }

    
}

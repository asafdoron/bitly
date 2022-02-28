package com.forwrd.bitly.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//mark class as an Entity 
@Entity
// defining class name as Table name
@Table
public class Url {
    
    @Id
    private String shortUrl;

    // @Column
    // private int id;
    
    @Column
    private String userId;

    // @Column
    // private String shortUrl;

    @Column
    private String longUrl;

    @Column
    private Timestamp createdDate;
        
    // public int getId() {
    //     return id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }

    
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

    public String getlongUrl() {
        return longUrl;
    }

    public void setlongUrl(String longUrl) {
        this.longUrl = longUrl;
    }


    public Timestamp getcreatedDate() {
        return createdDate;
    }

    public void setcreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

}
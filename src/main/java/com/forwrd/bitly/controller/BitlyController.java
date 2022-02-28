package com.forwrd.bitly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.Instant;  
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.forwrd.bitly.entity.Event;
import com.forwrd.bitly.entity.Url;
import com.forwrd.bitly.service.EventService;
import com.forwrd.bitly.service.UrlService;

@RestController
public class BitlyController {

  @Autowired
  UrlService urlService;
  
  @Autowired
  EventService eventService;

  static final String AB = "abcdefghijklmnopqrstuvwxyz";
  static SecureRandom rnd = new SecureRandom();

  static final int shorturlLen = 6;

  @GetMapping("/generate")
  public String generate(@RequestParam String userId, @RequestParam String originalUrl) {

    // Check if we used all short url options
    
    long count = urlService.count();

    if(count > Math.pow(AB.length(), shorturlLen))
    {
      // delete old urls or
      // not used urls
    }


    String shortURL = randomString(shorturlLen);

    while(urlService.exists(shortURL))
    {
      shortURL = randomString(shorturlLen);
    }

    System.out.println(shortURL);

    Timestamp ts = Timestamp.from(Instant.now());

    Url url = new Url();
    url.setuserId(userId);
    url.setlongUrl(originalUrl);
    url.setshortUrl(shortURL);
    url.setcreatedDate(ts);

    urlService.saveOrUpdate(url);

    return shortURL;

  }

  @GetMapping("/redirect/{shortUrl}")
  public RedirectView redirectAndLog(@PathVariable String shortUrl) {

    RedirectView redirectView = new RedirectView();

    if (urlService.exists(shortUrl)) {
      
      Url url =  urlService.getUrlById(shortUrl);

      String userId = url.getuserId();
      Timestamp ts = Timestamp.from(Instant.now());

      Event event = new Event();
      event.setuserId(userId);
      event.setredirectDate(ts);
      event.setshortUrl(shortUrl);

      eventService.saveOrUpdate(event);

      String longURL = url.getlongUrl();
      redirectView.setUrl(longURL);


    } else {
      redirectView.setUrl("https://github.com/asafdoron/notfound");
    }

    return redirectView;

  }

  @GetMapping("/events/{userId}")
  public List<Event> getEvents(@PathVariable String userId) {
    List<Event> events = eventService.getAllEvent();

    Predicate<Event> byUserId = event -> event.getuserId().equals(userId);

        var result = events.stream().filter(byUserId)
                .collect(Collectors.toList());

    return result;
  }

  String randomString(int len) {
    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++)
      sb.append(AB.charAt(rnd.nextInt(AB.length())));
    return sb.toString();
  }

}

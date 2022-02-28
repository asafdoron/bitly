package com.forwrd.bitly.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.forwrd.bitly.entity.Url;
import com.forwrd.bitly.repository.UrlRepository;

//defining the business logic
@Service
public class UrlService {
    @Autowired
    UrlRepository urlRepository;

    // getting all Url records
    public List<Url> getAllUrl() {
        List<Url> urls = new ArrayList<Url>();
        urlRepository.findAll().forEach(url -> urls.add(url));
        return urls;
    }

    // getting a specific record
    public Url getUrlById(String id) {
        return urlRepository.findById(id).get();
    }

    public void saveOrUpdate(Url url) {
        urlRepository.save(url);
    }

    // deleting a specific record
    public void delete(String id) {
        urlRepository.deleteById(id);
    }

    public boolean exists(String id){
        return urlRepository.existsById(id);
    }

    public long count() {

        return urlRepository.count();
    }


}
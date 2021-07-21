package com.example.demo4495.services;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class DeleteService {
    public boolean delete(String email) {
        RestTemplate restTemplate = new RestTemplate();
        String url
                = "http://45.76.207.32:8080/"+email;
        restTemplate.delete(url,String.class);
        return true;
    }
}

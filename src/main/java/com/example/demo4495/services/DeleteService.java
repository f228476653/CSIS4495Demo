package com.example.demo4495.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeleteService {
    @Value( "${db.url}" )
    private String dbUrl;
    public boolean delete(String email) {
        RestTemplate restTemplate = new RestTemplate();
        String url
                = dbUrl+email;
        restTemplate.delete(url,String.class);
        return true;
    }
}

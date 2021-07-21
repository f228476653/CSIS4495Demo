package com.example.demo4495.services;

import com.example.demo4495.models.MemberAccount;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class RegisterService {
    public MemberAccount addMember(MemberAccount memberAccount) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<MemberAccount> request = new HttpEntity<>(memberAccount);
        String value= "{\"value\":\""+memberAccount.getPassword()+"\"}";
        String url = "http://45.76.207.32:8080/"+memberAccount.getEmail();
        MemberAccount m = restTemplate.postForObject(url, value, MemberAccount.class);
        return memberAccount;
    }
}
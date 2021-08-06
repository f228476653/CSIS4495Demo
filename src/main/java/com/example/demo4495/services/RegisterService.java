package com.example.demo4495.services;

import com.example.demo4495.models.MemberAccount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class RegisterService {
    @Value( "${db.url}" )
    private String dbUrl;
    public MemberAccount addMember(MemberAccount memberAccount) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<MemberAccount> request = new HttpEntity<>(memberAccount);
        String value= "{\"value\":\""+memberAccount.getPassword()+"\"}";
        String url = dbUrl+memberAccount.getEmail();
        MemberAccount m = restTemplate.postForObject(url, value, MemberAccount.class);
        return memberAccount;
    }
}
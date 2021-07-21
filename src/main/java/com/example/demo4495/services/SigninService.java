package com.example.demo4495.services;

import com.example.demo4495.models.MemberAccount;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class SigninService {
    public MemberAccount signIn(MemberAccount memberAccount) throws IOException {
    RestTemplate restTemplate = new RestTemplate();
        String url
                = "http://45.76.207.32:8080/fetch/";
        ResponseEntity<String> response
                = restTemplate.getForEntity(url + memberAccount.getEmail(), String.class);
        JSONObject body = new JSONObject(new JSONObject(response).getString("body"));
        if(body.getString("value").equals(memberAccount.getPassword())){
            System.out.println("EXCUTE signIn MEMBER");
            return memberAccount;
        }else{
            return new MemberAccount();
        }
    }
}

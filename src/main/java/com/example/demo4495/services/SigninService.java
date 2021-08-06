package com.example.demo4495.services;

import com.example.demo4495.models.MemberAccount;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class SigninService {
    @Value( "${db.url}" )
    private String dbUrl;
    public MemberAccount signIn(MemberAccount memberAccount) throws IOException {
    RestTemplate restTemplate = new RestTemplate();
        String url
                = dbUrl+"fetch/";
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

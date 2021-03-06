package com.example.demo4495.controllers;

import com.example.demo4495.models.MemberAccount;
import com.example.demo4495.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class RegisterController {
    @Autowired
    MemberAccount memberAccount;

    @Autowired
    RegisterService registerService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MemberAccount memberAccount) throws IOException {
        try{
            return ResponseEntity.ok(registerService.addMember(memberAccount));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Map.of("message", e.getMessage())
            );
        }
    }
}

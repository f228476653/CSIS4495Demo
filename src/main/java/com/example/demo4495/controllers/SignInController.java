package com.example.demo4495.controllers;

import com.example.demo4495.models.MemberAccount;
import com.example.demo4495.services.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class SignInController {

    @Autowired
    SigninService signinService;
    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody MemberAccount memberAccount) throws IOException {
        try {
            return ResponseEntity.ok(signinService.signIn(memberAccount));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
               Map.of("message", e.getMessage())
            );
        }
    }
}

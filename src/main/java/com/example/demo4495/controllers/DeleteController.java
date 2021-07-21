package com.example.demo4495.controllers;

import com.example.demo4495.models.MemberAccount;
import com.example.demo4495.services.DeleteService;
import com.example.demo4495.services.RegisterService;
import com.example.demo4495.services.SigninService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Map;

@RestController
public class DeleteController {
    @Autowired
    DeleteService deleteService;

    @RequestMapping(value = "/api/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> delete(@RequestParam("email") String email) throws IOException {
        try{
            return ResponseEntity.ok(deleteService.delete(email));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    Map.of("message", e.getMessage())
            );
        }
    }
}

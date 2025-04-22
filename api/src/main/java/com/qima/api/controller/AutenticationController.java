package com.qima.api.controller;


import com.qima.api.users.DataAutentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager manager;
    @PostMapping
    public ResponseEntity makeLogin(@RequestBody DataAutentication datas){
        var token = new UsernamePasswordAuthenticationToken(datas.login(), datas.password());
        var authentication =manager.authenticate(token);
            return ResponseEntity.ok().build();
    }
}

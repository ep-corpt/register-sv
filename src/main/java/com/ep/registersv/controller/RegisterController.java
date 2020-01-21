package com.ep.registersv.controller;

import com.ep.registersv.model.MessageModel;
import com.ep.registersv.model.RegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @PostMapping
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody MessageModel messageModel) {
        return ResponseEntity.ok(new RegisterResponse());
    }

}

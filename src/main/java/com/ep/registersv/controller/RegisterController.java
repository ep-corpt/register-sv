package com.ep.registersv.controller;

import com.ep.registersv.common.RegisterException;
import com.ep.registersv.model.MessageModel;
import com.ep.registersv.model.RegisterResponse;
import com.ep.registersv.task.RegisterServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterServiceTask registerServiceTask;

    @PostMapping
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody MessageModel messageModel) throws RegisterException {
        return registerServiceTask.execute(messageModel);
    }

}

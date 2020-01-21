package com.ep.registersv.controller;

import com.ep.registersv.model.RegisterModel;
import com.ep.registersv.model.UserInfo;
import com.ep.registersv.producer.RegisterProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterProducer registerProducer;

    @GetMapping("/test/{name}")
    public String testMessage(@PathVariable("name") String name) {
        RegisterModel registerModel = new RegisterModel();
        registerModel.setUserInfo(new UserInfo("Kritchat", "Rojanaphruk"));
        registerProducer.produce(registerModel);
        return "worked";
    }

}

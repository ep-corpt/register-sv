package com.ep.registersv.task.impl;

import com.ep.registersv.common.RegisterException;
import com.ep.registersv.model.MessageModel;
import com.ep.registersv.model.RegisterResponse;
import com.ep.registersv.producer.RegisterProducer;
import com.ep.registersv.service.RegisterService;
import com.ep.registersv.task.RegisterServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RegisterServiceTaskImpl implements RegisterServiceTask {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private RegisterProducer registerProducer;

    @Override
    public ResponseEntity<RegisterResponse> execute(MessageModel messageModel) throws RegisterException {
        registerService.validateDuplicateData(messageModel);
        registerProducer.produce(messageModel);
        return ResponseEntity.ok(new RegisterResponse());
    }
}

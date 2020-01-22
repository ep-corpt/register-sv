package com.ep.registersv.task;

import com.ep.registersv.common.RegisterException;
import com.ep.registersv.model.MessageModel;
import com.ep.registersv.model.RegisterResponse;
import org.springframework.http.ResponseEntity;

public interface RegisterServiceTask {
    ResponseEntity<RegisterResponse> execute(MessageModel messageModel) throws RegisterException;
}

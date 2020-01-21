package com.ep.registersv.service.impl;

import com.ep.registersv.model.RegisterResponse;
import com.ep.registersv.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {
    @Override
    public ResponseEntity<RegisterResponse> execute() {

        return null;
    }
}

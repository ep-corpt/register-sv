package com.ep.registersv.service;

import com.ep.registersv.model.RegisterResponse;
import org.springframework.http.ResponseEntity;

public interface RegisterService {
    ResponseEntity<RegisterResponse> execute();
}

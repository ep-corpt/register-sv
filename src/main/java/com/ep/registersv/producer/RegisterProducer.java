package com.ep.registersv.producer;

import com.ep.registersv.model.RegisterModel;

public interface RegisterProducer {
    void produce(RegisterModel message);
}

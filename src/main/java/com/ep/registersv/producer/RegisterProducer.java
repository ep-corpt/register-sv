package com.ep.registersv.producer;

import com.ep.registersv.common.RegisterException;
import com.ep.registersv.model.MessageModel;

public interface RegisterProducer {
    void produce(MessageModel message) throws RegisterException;
}

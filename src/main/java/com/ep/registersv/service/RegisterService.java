package com.ep.registersv.service;

import com.ep.registersv.common.RegisterException;
import com.ep.registersv.model.MessageModel;

public interface RegisterService {
    void validateDuplicateData(MessageModel messageModel) throws RegisterException;
}

package com.ep.registersv.service.impl;

import com.ep.registersv.common.RegisterException;
import com.ep.registersv.dao.entity.CredentialInfo;
import com.ep.registersv.dao.repository.CredentialInfoRepository;
import com.ep.registersv.model.MessageModel;
import com.ep.registersv.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ep.registersv.constant.MessageConstant.EMAIL_IS_ALREADY_EXIST;
import static com.ep.registersv.constant.MessageConstant.USERNAME_IS_ALREADY_EXIST;

@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private CredentialInfoRepository credentialInfoRepository;

    @Override
    public void validateDuplicateData(MessageModel messageModel) throws RegisterException {
        validateDuplicateUsername(messageModel.getCredentialDetail().getUsername());
        validateDuplicateEmail(messageModel.getUserDetail().getEmail());
    }

    private void validateDuplicateEmail(String email) throws RegisterException {
        log.debug("validate email :{}", email);
        CredentialInfo credentialInfo = credentialInfoRepository.findByEmail(email).orElse(null);
        if (credentialInfo != null) {
            throw new RegisterException(EMAIL_IS_ALREADY_EXIST);
        }
    }


    private void validateDuplicateUsername(String username) throws RegisterException {
        log.debug("validate username :{}", username);
        CredentialInfo credentialInfo = credentialInfoRepository.findById(username).orElse(null);
        if (credentialInfo != null) {
            throw new RegisterException(USERNAME_IS_ALREADY_EXIST);
        }
    }
}

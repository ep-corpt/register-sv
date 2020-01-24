package com.ep.registersv.producer.impl;

import com.ep.registersv.common.RegisterException;
import com.ep.registersv.model.MessageModel;
import com.ep.registersv.producer.RegisterProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Objects;

import static com.ep.registersv.constant.MessageConstant.INTERNAL_SERVER_ERROR_PLS_TRY_AGAIN;

@Service
@Slf4j
public class RegisterProducerImpl implements RegisterProducer {

    @Autowired
    private KafkaTemplate<String, MessageModel> kafkaTemplate;

    @Autowired
    private Environment environment;

    @Override
    public void produce(MessageModel message) throws RegisterException {
        try {
            ListenableFuture<SendResult<String, MessageModel>> send = kafkaTemplate.send(Objects.requireNonNull(environment.getProperty("config.kafka.topic")), message);
            send.addCallback(new ListenableFutureCallback<SendResult<String, MessageModel>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    log.error("Exception", throwable);
                    throw new RuntimeException(throwable);
                }

                @Override
                public void onSuccess(SendResult<String, MessageModel> result) {
                    log.info("sent message='{}' with offset={}", message,
                            result.getRecordMetadata().offset());
                }
            });
        } catch (Exception e) {
            log.error("Exception occurred while sending message", e);
            throw new RegisterException(INTERNAL_SERVER_ERROR_PLS_TRY_AGAIN, e);
        }
    }
}

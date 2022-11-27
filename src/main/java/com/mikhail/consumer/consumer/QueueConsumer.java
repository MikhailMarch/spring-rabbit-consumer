package com.mikhail.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikhail.consumer.dto.UserDto;
import com.mikhail.consumer.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class QueueConsumer {

    private final ObjectMapper objectMapper;
    private final UserService userService;

    @RabbitListener(queues = "user")
    public void consumeRecord(String record) throws JsonProcessingException {
        log.info("recieved record {}", record);
        var user = objectMapper.convertValue(record, UserDto.class);

        switch (user.getType()) {
            case SELLER -> userService.saveSeller(user.getName());
            case CUSTOMER -> userService.saveCustomer(user.getName());
        }
    }
}

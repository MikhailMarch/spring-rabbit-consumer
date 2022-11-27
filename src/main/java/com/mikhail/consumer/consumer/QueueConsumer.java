package com.mikhail.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikhail.consumer.dto.UserDto;
import com.mikhail.consumer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QueueConsumer {

    private final ObjectMapper objectMapper;
    private final UserService userService;

    @RabbitListener(queues = "user")
    public void consumeRecord(String record) throws JsonProcessingException {
        var user = objectMapper.readValue(record, UserDto.class);

        switch (user.getType()) {
            case SELLER -> userService.saveSeller(user.getName());
            case CUSTOMER -> userService.saveCustomer(user.getName());
        }
    }
}

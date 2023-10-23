package com.ms.email.consumer;

import com.ms.email.model.EmailModel;
import com.ms.email.model.dto.EmailDTO;
import com.ms.email.service.EmailServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailServiceImpl emailService;

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void listen (@Payload EmailDTO emailDTO) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        emailService.sendEmail(emailModel);
    }

}

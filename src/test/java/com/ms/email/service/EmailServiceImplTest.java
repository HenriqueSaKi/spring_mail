package com.ms.email.service;

import com.ms.email.mock.EmailModelMock;
import com.ms.email.mock.exception.MailExceptionMock;
import com.ms.email.model.EmailModel;
import com.ms.email.repository.EmailRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@ExtendWith(MockitoExtension.class)
public class EmailServiceImplTest {

    @Mock
    EmailRepository repository;

    @Mock
    JavaMailSender mailSender;

    @InjectMocks
    EmailServiceImpl service;

    @Test
    public void testSendEmail() {
        EmailModel model = new EmailModelMock().getEmailModel();

        Mockito.doNothing().when(mailSender).send(Mockito.any(SimpleMailMessage.class));
        service.sendEmail(model);

        Mockito.verify(repository).save(Mockito.any());

    }

    @Test
    public void testMailException() {
        Mockito.doThrow(new MailExceptionMock("Forced Error"))
                .when(mailSender).send(Mockito.any(SimpleMailMessage.class));
        service.sendEmail(new EmailModel());

        Mockito.verify(repository).save(Mockito.any());

    }


}

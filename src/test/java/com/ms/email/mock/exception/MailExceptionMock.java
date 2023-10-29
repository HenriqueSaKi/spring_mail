package com.ms.email.mock.exception;

import org.springframework.mail.MailException;

public class MailExceptionMock extends MailException {
    public MailExceptionMock(String msg) {
        super(msg);
    }

}

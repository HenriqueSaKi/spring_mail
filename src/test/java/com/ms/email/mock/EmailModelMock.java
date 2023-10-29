package com.ms.email.mock;

import com.ms.email.enums.StatusEmail;
import com.ms.email.model.EmailModel;

import java.time.LocalDateTime;

public class EmailModelMock {

    public EmailModel getEmailModel() {
        EmailModel model = new EmailModel();
        model.setEmailId(1L);
        model.setOwnerRef("Owner Ref");
        model.setEmailFrom("emailfrom@example.com");
        model.setEmailTo("emailto@example.com");
        model.setSubject("Subject");
        model.setText("Text");
        model.setSendDateEmail(LocalDateTime.now());
        model.setStatusEmail(StatusEmail.SENT);

        return model;

    }

}

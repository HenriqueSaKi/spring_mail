package com.ms.email.model;

import com.ms.email.enums.StatusEmail;
import com.ms.email.mock.EmailModelMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmailModelTest {

    @Test
    public void testEmailModel() {
        EmailModel model = new EmailModelMock().getEmailModel();

        Assertions.assertEquals(1L, model.getEmailId());
        Assertions.assertEquals("Owner Ref", model.getOwnerRef());
        Assertions.assertEquals("emailfrom@example.com", model.getEmailFrom());
        Assertions.assertEquals("emailto@example.com", model.getEmailTo());
        Assertions.assertEquals("Subject", model.getSubject());
        Assertions.assertEquals("Text", model.getText());
        Assertions.assertNotNull(model.getSendDateEmail());
        Assertions.assertEquals(StatusEmail.SENT, model.getStatusEmail());

        model.setStatusEmail(StatusEmail.ERROR);
        Assertions.assertEquals(StatusEmail.ERROR, model.getStatusEmail());

    }

}

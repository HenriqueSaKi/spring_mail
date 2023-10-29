package com.ms.email.model.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.*;
import java.util.Set;

public class EmailDTOTest {

    @Test
    public void testEmailDTO() {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setOwnerRef("Owner Ref");
        emailDTO.setEmailFrom("emailfrom@example.com");
        emailDTO.setEmailTo("emailto@example.com");
        emailDTO.setSubject("Subject");
        emailDTO.setText("Text");

        Assertions.assertEquals("Owner Ref", emailDTO.getOwnerRef());
        Assertions.assertEquals("emailfrom@example.com", emailDTO.getEmailFrom());
        Assertions.assertEquals("emailto@example.com", emailDTO.getEmailTo());
        Assertions.assertEquals("Subject", emailDTO.getSubject());
        Assertions.assertEquals("Text", emailDTO.getText());

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<EmailDTO>> violations = validator.validate(emailDTO);
        Assertions.assertTrue(violations.isEmpty());

    }

}

package com.ms.email.model.dto;

import com.ms.email.mock.dto.EmailDTOMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.*;
import java.util.Set;

public class EmailDTOTest {

    @Test
    public void testEmailDTO() {
        EmailDTO emailDTO = new EmailDTOMock().getEmailDTO();

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

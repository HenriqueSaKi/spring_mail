package com.ms.email.mock.dto;

import com.ms.email.model.dto.EmailDTO;

public class EmailDTOMock {

    public EmailDTO getEmailDTO() {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setOwnerRef("Owner Ref");
        emailDTO.setEmailFrom("emailfrom@example.com");
        emailDTO.setEmailTo("emailto@example.com");
        emailDTO.setSubject("Subject");
        emailDTO.setText("Text");

        return emailDTO;

    }

}

package com.ms.email.controller;

import com.google.gson.Gson;
import com.ms.email.mock.dto.EmailDTOMock;
import com.ms.email.model.EmailModel;
import com.ms.email.model.dto.EmailDTO;
import com.ms.email.service.EmailServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class EmailControllerTest {

    @Mock
    EmailServiceImpl service;

    @InjectMocks
    EmailController controller;

    MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .alwaysDo(print())
                .build();

    }

    @Test
    public void testHealthCheck() throws Exception {
        String response = mockMvc.perform(get("/healthCheck"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Assertions.assertEquals("The service is available!", response);

    }

    @Test
    public void testSendEmail() throws Exception {
        EmailDTO emailDTO = new EmailDTOMock().getEmailDTO();
        String emailDTO2Json = mockMvc.perform(
                        post("/send_email")
                                .contentType("application/json")
                                .content(new Gson().toJson(emailDTO)))
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString();
        Mockito.verify(service).sendEmail(Mockito.any(EmailModel.class));

        EmailModel response = new Gson().fromJson(emailDTO2Json, EmailModel.class);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(emailDTO.getOwnerRef(), response.getOwnerRef());
        Assertions.assertEquals(emailDTO.getEmailFrom(), response.getEmailFrom());
        Assertions.assertEquals(emailDTO.getEmailTo(), response.getEmailTo());
        Assertions.assertEquals(emailDTO.getSubject(), response.getSubject());
        Assertions.assertEquals(emailDTO.getText(), response.getText());


    }

    @Test
    public void testException() throws Exception {
        mockMvc.perform(post("/send_email")
                .contentType("application/json")
                        .content(new Gson().toJson(null)))
                .andExpect(status().isBadRequest());

    }

}

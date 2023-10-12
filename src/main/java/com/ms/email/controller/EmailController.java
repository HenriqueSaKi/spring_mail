package com.ms.email.controller;

import com.ms.email.model.EmailModel;
import com.ms.email.model.dto.EmailDTO;
import com.ms.email.service.EmailServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController()
public class EmailController {

    @Autowired
    EmailServiceImpl service;

    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck () {
        return ResponseEntity.status(HttpStatus.OK).body("The service is available!");
    }

    @PostMapping("/send_email")
    public ResponseEntity<EmailModel> sendEmail (@RequestBody @Valid EmailDTO emailDTO) {
        try {
            EmailModel emailModel = new EmailModel();
            BeanUtils.copyProperties(emailDTO, emailModel);
            service.sendEmail(emailModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(emailModel);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}

/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.49).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.ms.email.controller;

import com.ms.email.model.EmailModel;
import com.ms.email.model.dto.EmailDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-10-24T11:34:47.438626947Z[GMT]")
@Validated
public interface EmailApi {

    @Operation(summary = "Place order", description = "Place order", tags={ "email" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "successful operation", content = @Content(mediaType = "application/json", schema =
            @Schema(implementation = EmailModel.class))),
        @ApiResponse(responseCode = "404", description = "send email failed", content = @Content(mediaType = "application/json", schema =
            @Schema(implementation = String.class), examples = @ExampleObject("Error message"))) })
    @RequestMapping(value = "/send_email",
            produces = { "application/json" },
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Object> sendEmail(@Parameter(in = ParameterIn.DEFAULT, description = "", schema=@Schema()) @Valid @RequestBody EmailDTO body);

}


package com.ms.email.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-10-24T11:34:47.438626947Z[GMT]")
@Validated
public interface HealthCheckApi {

    @Operation(summary = "Service status", description = "Returns service status", tags={ "email" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema =
            @Schema(implementation = String.class), examples = @ExampleObject("The service is available!"))) })
    @RequestMapping(value = "/healthCheck",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<String> healthCheck();

}
package com.example.construction_company_management.annotation;

import com.example.construction_company_management.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.POST)
@Operation(
        summary = "Create new User",
        description = "Create new User",
        tags = {"USER"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "USER to be created",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = User.class),
                        examples = {
                                @ExampleObject(name = "Good request",
                                        value = """
                                                {
                                                    "firstName": "Slava",
                                                    "lastName": "Bolshov",
                                                    "dateOfBirth": "1992-11-09",
                                                    "registrationDate": "2023-10-15",
                                                    "userName": "USER123",
                                                    "password": "123123",
                                                    "phoneNumber": "07512378890",
                                                    "roleName": "ROLE_PROJECT_MANAGER"                                              
                                                }
                                                """
                                ),

                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "201",
                        description = "User created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = User.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "User already exists",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ResponseEntityExceptionHandler.class)
                        )
                )
        }


)
public @interface CreateUser {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}

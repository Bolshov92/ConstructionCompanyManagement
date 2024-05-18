package com.example.construction_company_management.annotation;

import com.example.construction_company_management.entity.Employee;
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
        summary = "Create new employee",
        description = "Create new employees",
        tags = {"EMPLOYEE"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "The Employee to be created",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Employee.class),
                        examples = {
                                @ExampleObject(name = "Good request",
                                        value = """
                                                   {
                                                   "firstName":"Viacheslav",
                                                   "lastName":"Bolshov",
                                                   "contactInfo":"bolshov@gmail.com",
                                                   "age":31,
                                                   "hireDate":"2023-11-09",
                                                   "endDate":"2024-11-09",
                                                   "depName":"IT",
                                                   "roleName":"ROLE_SUPERVISOR"
                                                }"""),
                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Employee created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Employee.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Employee already exists",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ResponseEntityExceptionHandler.class)
                        )
                )
        }
)
public @interface CreateEmployee {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}

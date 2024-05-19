package com.example.construction_company_management.annotation;

import com.example.construction_company_management.entity.Department;
import io.swagger.annotations.Api;
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
        summary = "Create new Department",
        description = "Create new Department",
        tags = {"DEPARTMENT"},
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Department to be created",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Department.class),
                        examples = {
                                @ExampleObject(name = "Good request",
                                        value = """
                                                {
                                                "depName": "ExampleDepartment"                                                
                                                }
                                                """
                                ),

                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Department created",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Department.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Department already exists",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ResponseEntityExceptionHandler.class)
                        )
                )
        }


)
public @interface CreateDepartment {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}
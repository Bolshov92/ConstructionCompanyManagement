package com.example.construction_company_management.annotation;


import com.example.construction_company_management.controller.handler.ErrorMessage;
import com.example.construction_company_management.entity.Department;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation for GET requests to retrieve a department by its name.
 * This annotation configures Swagger documentation to describe the API endpoint.
 * It includes request parameters, response messages, and example usage.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@Operation(
        summary = "Get department by name and return its contents",
        description = "Get department By Name",
        tags = {"DEPARTMENT"},
        parameters = {
                @Parameter(
                        name = "depName",
                        description = "Name of Department",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Example with correct department name",
                                        value = "IT"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Department name is found",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Department.class)
                        )
                ),

                @ApiResponse(
                        responseCode = "404",
                        description = "Department not found",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ErrorMessage.class)
                        )
                )
        }
)
public @interface GetDepartmentByName {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}

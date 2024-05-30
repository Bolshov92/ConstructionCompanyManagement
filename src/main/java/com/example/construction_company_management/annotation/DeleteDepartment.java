package com.example.construction_company_management.annotation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
 * Custom annotation for DELETE requests to delete a department by ID.
 * This annotation configures Swagger documentation to describe the API endpoint.
 * It includes parameter details, response messages, and example usage.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.DELETE)
@Operation(
        summary = "Delete department by ID",
        description = "Delete department by its unique identifier",
        tags = {"DEPARTMENT"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique identifier of the department",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Example existing ID",
                                        value = "cb5d6730-c117-473b-9ded-d4cf57a53d75"
                                ),
                                @ExampleObject(
                                        name = "Example none-existing ID",
                                        value = "cb5d6730-c117-473b-9ded-d4cf57a53d71"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Department was removed"
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Department doesn't exist"
                )
        }
)
public @interface DeleteDepartment {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}

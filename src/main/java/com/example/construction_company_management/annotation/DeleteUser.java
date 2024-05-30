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
 * Custom annotation for DELETE requests to delete a user by ID.
 * This annotation configures Swagger documentation to describe the API endpoint.
 * It includes parameter details, response messages, and example usage.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.DELETE)
@Operation(
        summary = "Delete User by ID",
        description = "Delete user by its unique identifier",
        tags = {"USER"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique identifier of the user",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(type = "string", format = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Example existing ID",
                                        value = "0f9368f4-518f-48cb-b917-2f0f967dd41e"
                                ),
                                @ExampleObject(
                                        name = "Example none-existing ID",
                                        value = "0f9368f4-518f-48cb-b917-2f0f967dd41A"
                                )
                        }
                )
        },
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "User was removed"
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "User doesn't exist"
                )
        }
)
public @interface DeleteUser {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}

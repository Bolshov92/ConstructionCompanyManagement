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

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.PUT)
@Operation(
        summary = "Update name of Department by Id",
        description = "Request for update department name by department ID",
        tags = {"DEPARTMENT"},
        parameters = {
                @Parameter(
                        name = "id",
                        description = "The unique identifier of the department",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(format = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Correct Id",
                                        value = "cb5d6730-c117-473b-9ded-d4cf57a53d75"
                                )
                        }
                )
        },
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Request to update department name",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Department.class),
                        examples = {
                                @ExampleObject(
                                        name = "Update name",
                                        value = """
                                                {
                                                "depName" : "HR"
                                                }
                                                """
                                )
                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Department name was updated",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Department.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Department is not found",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ErrorMessage.class)
                        )
                )
        }
)
public @interface UpdateDepartment {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}

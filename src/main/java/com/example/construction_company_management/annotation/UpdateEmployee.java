package com.example.construction_company_management.annotation;

import com.example.construction_company_management.entity.Employee;
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
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.PUT)
@Operation(
        summary = "Update employee",
        description = "Request for update info of Employee",
        tags = {"EMPLOYEE"},
        parameters = {
                @Parameter(
                        name = "Employee info ID",
                        description = "The unique identifier of the employee",
                        required = true,
                        in = ParameterIn.PATH,
                        schema = @Schema(format = "string"),
                        examples = {
                                @ExampleObject(
                                        name = "Correct id",
                                        value = "639d7bc4-9845-40aa-84c8-b0f1dced6732"
                                )
                        }
                )
        },
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Request to update employee info",
                required = true,
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Employee.class),
                        examples = {
                                @ExampleObject(
                                        name = "Update Employee",
                                        value = """
                                                {
                                                   "firstName":"Viacheslav",
                                                   "lastName":"Bolshov",
                                                   "contactInfo":"bolshov@gmail.com",
                                                   "age":31,
                                                   "hireDate":"2023-11-09",
                                                   "endDate":"2024-11-09",
                                                   "depName":"Driver",
                                                   "roleName":"ROLE_DEFAULT_USER"
                                                }
                                                """
                                )
                        }
                )
        ),
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Employee Info was updated",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = Employee.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Employee info not found",
                        content = @Content(
                                mediaType = "application/jsom",
                                schema = @Schema(implementation = ResponseEntityExceptionHandler.class)
                        )
                )
        }

)
public @interface UpdateEmployee {
    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String[] path() default {};
}

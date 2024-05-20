package com.example.construction_company_management.controller.handler;

import com.example.construction_company_management.exсeption.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(RoleIsNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleRoleIsNotFoundException(Exception e) {
        return new ResponseEntity<>(new ErrorMessage(
                e.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthorityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleAuthorityNotFoundException(Exception e) {
        return new ResponseEntity<>(new ErrorMessage(
                e.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleUserNotFoundException(Exception e) {
        return new ResponseEntity<>(new ErrorMessage(
                e.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleUserAlreadyExistsException(Exception e) {
        return new ResponseEntity<>(new ErrorMessage(
                e.getMessage(), HttpStatus.CONFLICT),
                HttpStatus.CONFLICT);

    }

    @ExceptionHandler(DepartmentAlreadyExists.class)
    public ResponseEntity<ErrorMessage> handleDepartmentAlreadyExists(Exception e) {
        return new ResponseEntity<>(new ErrorMessage(
                e.getMessage(), HttpStatus.CONFLICT),
                HttpStatus.CONFLICT);

    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleDepartmentNotFoundException(Exception e) {
        return new ResponseEntity<>(new ErrorMessage(
                e.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<ErrorMessage> handleEmployeeAlreadyExists(Exception e) {
        return new ResponseEntity<>(new ErrorMessage(
                e.getMessage(), HttpStatus.CONFLICT),
                HttpStatus.CONFLICT);

    }

    @ExceptionHandler(EmployeeNotExistExсeption.class)
    public ResponseEntity<ErrorMessage> handleEmployeeNotExistException(Exception e) {
        return new ResponseEntity<>(new ErrorMessage(
                e.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeIsNotFound.class)
    public ResponseEntity<ErrorMessage> handleEmployeeIsNotFound(Exception e) {
        return new ResponseEntity<>(new ErrorMessage(
                e.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);

    }
}
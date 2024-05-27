package com.example.construction_company_management.aspect;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Pointcut("execution(public * com.example.construction_company_management.controller.*.*(..))")
    public void controllerLog() {
    }

    @Pointcut("execution(public * com.example.construction_company_management.service.*.*(..))")
    public void serviceLog() {
    }

    @Before("controllerLog()")
    public void doBeforeController(JoinPoint jp) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes != null ? attributes.getRequest() : null;
        if (request != null) {
            String logMessage = """
                    NEW REQUEST:
                    IP : %s
                    URL : %s
                    HTTP_METHOD : %s
                    CONTROLLER_METHOD : %s.%s
                    """.formatted(
                    request.getRemoteAddr(),
                    request.getRequestURL().toString(),
                    request.getMethod(),
                    jp.getSignature().getDeclaringTypeName(),
                    jp.getSignature().getName());

            log.info(logMessage);
        }
    }

    @Before("serviceLog()")
    public void doBeforeService(JoinPoint jp) {
        String logMessage = """
                RUN SERVICE:
                SERVICE_METHOD : %s.%s
                """.formatted(
                jp.getSignature().getDeclaringTypeName(),
                jp.getSignature().getName());

        log.info(logMessage);
    }

    @AfterReturning(returning = "returnObject", pointcut = "controllerLog()")
    public void doAfterReturning(Object returnObject) {
        String logMessage = """
                Return value: %s
                END OF REQUEST
                """.formatted(returnObject);

        log.info(logMessage);
    }

    @AfterThrowing(throwing = "ex", pointcut = "controllerLog()")
    public void throwsException(JoinPoint jp, Exception ex) {
        String logMessage = """
                Request threw an exception. Arguments - %s. Cause - %s
                """.formatted(
                Arrays.toString(jp.getArgs()),
                ex.getMessage());

        log.error(logMessage);
    }
}
package com.example.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @Around("execution(* com.example.controller.*.*(..))")
    public Object doAroundController(ProceedingJoinPoint joinPoint) throws Throwable {

        ObjectMapper om = new ObjectMapper();
        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.BEFORERUNNINGCLASS
                + joinPoint.getSignature().getDeclaringTypeName());

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRUNNINGMETHOD
                + joinPoint.getSignature().getName());

        Object[] ss = joinPoint.getArgs();

        for (int i = 0; i < ss.length; i++) {
            if ((ss[i] != null)
                    && "org.apache.catalina.connector.RequestFacade".equalsIgnoreCase(ss[i].getClass().getName())) {
                ss[i] = "Removed the request object";
            }
        }

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + " Arguments passed to method/Request Parameters : "
                + om.writerWithDefaultPrettyPrinter().writeValueAsString(ss));
        Object value = joinPoint.proceed();

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRUNNINGCLASS
                + joinPoint.getSignature().getDeclaringTypeName());

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRUNNINGMETHOD
                + joinPoint.getSignature().getName());

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRETURNVALUE
                + om.writerWithDefaultPrettyPrinter().writeValueAsString(value));

        return value;
    }

    @Around("execution(* com.example.service.*.*(..))")
    public Object doAroundService(ProceedingJoinPoint joinPoint) throws Throwable {

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.BEFORERUNNINGCLASS
                + joinPoint.getSignature().getDeclaringTypeName());

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRUNNINGMETHOD
                + joinPoint.getSignature().getName());
        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.METHODARGS
                + Arrays.toString(joinPoint.getArgs()));

        Object value = joinPoint.proceed();

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRUNNINGCLASS
                + joinPoint.getSignature().getDeclaringTypeName());

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRUNNINGMETHOD
                + joinPoint.getSignature().getName());

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRETURNVALUE + value);

        return value;
    }

    @Around("execution(* com.example.dao.*.*(..))")
    public Object doAroundResourceHelper(ProceedingJoinPoint joinPoint) throws Throwable {

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.BEFORERUNNINGCLASS
                + joinPoint.getSignature().getDeclaringTypeName());

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRUNNINGMETHOD
                + joinPoint.getSignature().getName());
        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.METHODARGS
                + Arrays.toString(joinPoint.getArgs()));

        Object value = joinPoint.proceed();

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRUNNINGCLASS
                + joinPoint.getSignature().getDeclaringTypeName());

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRUNNINGMETHOD
                + joinPoint.getSignature().getName());

        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRETURNVALUE + value);

        return value;
    }

    @Around("execution(* com.example.exception.*.*(..)) ")

    public Object doAroundException(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.BEFORERUNNINGCLASS
                + joinPoint.getSignature().getDeclaringTypeName());
        LOGGER.error(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRUNNINGMETHOD
                + joinPoint.getSignature().getName());
        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.METHODARGS
                + Arrays.toString(joinPoint.getArgs()));
        Object value = joinPoint.proceed();
        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRUNNINGCLASS
                + joinPoint.getSignature().getDeclaringTypeName());
        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRUNNINGMETHOD
                + joinPoint.getSignature().getName());
        LOGGER.debug(ApplicationConstants.LOGMESSAGE + ApplicationConstants.AFTERRETURNVALUE + value);
        return value;
    }

    

}
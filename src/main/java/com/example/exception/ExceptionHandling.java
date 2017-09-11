package com.example.exception;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.exception.GenericJDBCException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.exception.domain.AccountIdNotFoundException;

@EnableWebMvc
@ControllerAdvice
public class ExceptionHandling {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandling.class);

    @Autowired
    private MessageHandler      messageHandler;

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(value = { InvalidMediaTypeException.class,
            HttpMediaTypeNotSupportedException.class })
    public void handleUnsupportedMediaTypeException() {
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = { HttpMessageNotReadableException.class, MissingServletRequestParameterException.class,
            ServletRequestBindingException.class, TypeMismatchException.class, HttpMessageNotReadableException.class,
            MissingServletRequestPartException.class, BindException.class })
    public void handleBadRequestException() {
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public void handleMethodNotAllowedException() {
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = { MissingPathVariableException.class, ConversionNotSupportedException.class,
            HttpMessageNotWritableException.class })
    public void handleInternalServerErrorException() {
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(value = HttpMediaTypeNotAcceptableException.class)
    public void handleMediaTypeNotAcceptableException() {
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public OperationsErrorBean handleGlobalException(final HttpServletRequest request, final Exception ex) {
        LOGGER.error("Unhandled Exception Occurred: ", ex);
        return errorResponse("1000", messageHandler.localizeErrorMessage("error.1000"), "", request.getRequestURI(),
                request.getAttribute("startTime").toString());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = { CannotCreateTransactionException.class, SQLException.class, PersistenceException.class,
            GenericJDBCException.class, InvalidDataAccessResourceUsageException.class })
    @ResponseBody
    public OperationsErrorBean handleSQLException(final HttpServletRequest request, final Exception ex) {
        LOGGER.error("Database Exception Occurred: ", ex);
        return errorResponse("1001", messageHandler.localizeErrorMessage("error.1001"), "", request.getRequestURI(),
                request.getAttribute("startTime").toString());
    }
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = { AccountIdNotFoundException.class })
    @ResponseBody
    public OperationsErrorBean handleAcoountIdNotFoundException(final HttpServletRequest request, final Exception ex) {
        LOGGER.error("Database Exception Occurred: ", ex);
        return errorResponse("1002", "The requested resource was not found.", "", request.getRequestURI(),
        		DateUtils.getUTCDate());
    }

   
    public OperationsErrorBean errorResponse(final String errorCode, final String errorMessage,
            final String errorFieldName, final String errorUrl, final String timeStamp) {
        final OperationsErrorBean operationError = new OperationsErrorBean();
        final OperationBean operation = new OperationBean();
        final ErrorBean error = new ErrorBean();
        final ArrayList<ErrorBean> errors = new ArrayList<>();
        operation.setResult("ERROR");
        error.setCode(errorCode);
        error.setMessage(errorMessage);
        error.setField(errorFieldName);
        errors.add(error);
        operation.setErrors(errors);
        operation.setRequestTimeStampUtc(timeStamp);
        operation.setResponseTimeStampUtc(DateUtils.getUTCDate());
        operationError.setOperation(operation);
        return operationError;
    }
}
package com.example.simplebank.configs.errorhandling;

import com.example.simplebank.shareddomain.commons.exceptions.AppException;
import com.example.simplebank.shareddomain.commons.utils.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.example.simplebank.shareddomain.commons.constants.AppConstant.*;

@Slf4j
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<?> handleAppException(AppException ex) {
        log.error("GLOBAL handleAppException", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ex.getField(), ex.getMessage()));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        log.error("GLOBAL handleException", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("GLOBAL handleIllegalArgumentException", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleHttpRequestMethodNotSupported", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleHttpMediaTypeNotSupported", ex);
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleHttpMediaTypeNotAcceptable", ex);
        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleMissingPathVariable", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleMissingServletRequestParameter", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleServletRequestBindingException", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleConversionNotSupported", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleTypeMismatch", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleHttpMessageNotReadable", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleHttpMessageNotWritable", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleMethodArgumentNotValid", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleMissingServletRequestPart", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleBindException", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleNoHandlerFoundException", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
        log.error("GLOBAL handleAsyncRequestTimeoutException", ex);
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error("GLOBAL handleExceptionInternal", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(AppUtils.errorResponse(ERROR_TITLE, ERROR_TITLE, ERROR_MESSAGE));
    }

}

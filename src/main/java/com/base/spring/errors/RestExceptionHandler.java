package com.base.spring.errors;

import com.base.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;


@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private Message message;

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage(), ex);

        String errorMessage = String.format(message.getMessage("error.param-missing"), ex.getParameterName());
        APIError error = APIError.builder().
                message(errorMessage).
                debugMessage(ex.getLocalizedMessage()).
                build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
                                                                     HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage(), ex);

        StringBuilder supportMedia = new StringBuilder();
        ex.getSupportedMediaTypes().forEach(t -> supportMedia.append(t).append(", "));
        String errorMessage = String.format(message.getMessage("error.media-not-support"),
                ex.getContentType(), supportMedia.substring(0, supportMedia.length() - 2));

        APIError error = APIError.builder().
                message(errorMessage).
                debugMessage(ex.getLocalizedMessage()).
                build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage(), ex);

        APIError error = APIError.builder().
                message(ex.getLocalizedMessage()).
                debugMessage(ex.getLocalizedMessage()).
                build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage(), ex);


        APIError error = APIError.builder().
                message(message.getMessage("error.validation")).
                build();
        error.addValidationErrors(ex.getBindingResult().getFieldErrors());
        error.addValidationError(ex.getBindingResult().getGlobalErrors());

        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        log.info("{} to {}", servletWebRequest.getHttpMethod(), servletWebRequest.getRequest().getServletPath());

        String errorMessage = message.getMessage("error.malformed-json");

        APIError error = APIError.builder().
                message(errorMessage).
                debugMessage(ex.getLocalizedMessage()).
                build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage(), ex);

        APIError error = APIError.builder().
                message(message.getMessage("error.writing-json")).
                debugMessage(ex.getLocalizedMessage()).
                build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
                                                                   HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage(), ex);

        APIError error = APIError.builder().
                message(String.format(message.getMessage("error.no-handler"), ex.getHttpMethod(), ex.getRequestURL())).
                debugMessage(ex.getLocalizedMessage()).
                build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), BAD_REQUEST, request);
    }

    /**
     * Handler authentication exception.
     *
     * @param ex      the exception
     * @param request the request
     * @return ResponseEntity
     */
    @ExceptionHandler({BadCredentialsException.class})
    public ResponseEntity<Object> handleAuthenticationException(Exception ex, WebRequest request) {
        log.error("401 Status Code", ex);

        APIError error = APIError.builder().
                message(message.getMessage("error.authentication")).
                debugMessage(ex.getMessage()).
                build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), UNAUTHORIZED, request);
    }

    /**
     * Handler Internal error.
     *
     * @param ex      the exception
     * @param request the request
     * @return ResponseEnity
     */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleInternal(RuntimeException ex, WebRequest request) {
        log.error("500 Status Code", ex);

        APIError error = APIError.builder().
                message(message.getMessage("error.message")).
                debugMessage(ex.getMessage()).
                build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
    }

    /**
     * handler OAuth2Exception
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler({OAuth2Exception.class})
    public ResponseEntity<Object> handlerOAuth2Exception(OAuth2Exception ex, WebRequest request) {
        log.error("######" + ex.getMessage(), ex);

        APIError error = APIError.builder().
                message(ex.getMessage()).
                build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
    }

    /**
     * handle InvalidTokenException
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler({InvalidTokenException.class})
    public ResponseEntity<Object> handleInvalidTokenException(Exception ex, WebRequest request) {
        log.error("######" + ex.getMessage(), ex);

        APIError error = APIError.builder().
                message(ex.getMessage()).
                build();

        return handleExceptionInternal(ex, error, new HttpHeaders(), INTERNAL_SERVER_ERROR, request);
    }

}

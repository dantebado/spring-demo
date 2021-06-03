package com.dantebado.springsampledds.config;

import com.dantebado.springsampledds.exceptions.GenericException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerConfiguration {

    @ExceptionHandler(value = GenericException.class)
    public ResponseEntity<Object> exception(GenericException exception, WebRequest request) {
        return new ResponseEntity<>(exception, exception.getStatus());
    }

}

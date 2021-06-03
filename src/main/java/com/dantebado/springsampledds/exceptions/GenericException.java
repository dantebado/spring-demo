package com.dantebado.springsampledds.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Calendar;

@Data
@NoArgsConstructor
@JsonIgnoreProperties({ "suppressed", "localizedMessage", "stackTrace", "cause" })
public class GenericException extends RuntimeException {

    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.NOT_FOUND;

    HttpStatus status;
    Calendar date;
    String message;
    ExceptionType type;

    public enum ExceptionType {
        PET_NOT_FOUND
    }

    public GenericException(String message, ExceptionType type) {
        super();
        this.message = message;
        this.date = Calendar.getInstance();
        this.type = type;
        this.status = DEFAULT_HTTP_STATUS;
    }

}

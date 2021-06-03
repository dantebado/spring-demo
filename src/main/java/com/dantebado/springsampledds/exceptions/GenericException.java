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

    public GenericException(String message) {
        super();
        this.message = message;
        this.date = Calendar.getInstance();
        this.status = DEFAULT_HTTP_STATUS;
    }

}

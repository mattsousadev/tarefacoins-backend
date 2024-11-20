package br.mattsousa.domain.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppException extends RuntimeException {

    private HttpStatus status = HttpStatus.BAD_REQUEST;
    
    public AppException(String message) {
        super(message);
        status = HttpStatus.BAD_REQUEST;
    }
}

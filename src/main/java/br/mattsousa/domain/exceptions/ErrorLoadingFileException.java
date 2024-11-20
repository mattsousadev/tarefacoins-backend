package br.mattsousa.domain.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorLoadingFileException extends AppException {
    public ErrorLoadingFileException(String message) {
        super(message);
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

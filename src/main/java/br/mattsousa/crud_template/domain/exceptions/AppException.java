package br.mattsousa.crud_template.domain.exceptions;

public class AppException extends RuntimeException {
    public AppException(String message) {
        super(message);
    }
}

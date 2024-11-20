package br.mattsousa.domain.exceptions;

public class EmailAlreadyRegisteredException extends AppException {
    public EmailAlreadyRegisteredException(String message) {
        super(message);
    }
}

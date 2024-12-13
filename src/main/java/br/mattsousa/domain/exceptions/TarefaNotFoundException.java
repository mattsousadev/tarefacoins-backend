package br.mattsousa.domain.exceptions;

public class TarefaNotFoundException extends AppException {
    public TarefaNotFoundException(String message) {
        super(message);
    }
}
package br.mattsousa.beans;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.mattsousa.domain.exceptions.AppException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class ErrorResponse {
    private Boolean success;
    private Integer code;
    private String message;
}

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<ErrorResponse> handleConflict(RuntimeException ex, WebRequest request) {
        ErrorResponse body = new ErrorResponse();
        body.setSuccess(false);
        body.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        body.setMessage("Unknown Error");
        return ResponseEntity.internalServerError().body(body);
    }


    @ExceptionHandler(value = {AppException.class})
    protected ResponseEntity<ErrorResponse> handleAppException(AppException ex, WebRequest request) {
        ErrorResponse body = new ErrorResponse();
        body.setSuccess(ex.getStatus().is2xxSuccessful());
        body.setCode(ex.getStatus().value());
        body.setMessage(ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(body);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
            ErrorResponse body = new ErrorResponse();
            body.setSuccess(status.is2xxSuccessful());
            body.setCode(status.value());
            String error = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
            body.setMessage(error);
            return ResponseEntity.status(status).body(body);
    }

    
}
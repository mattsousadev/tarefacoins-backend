package br.mattsousa.beans;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        body.setSuccess(false);
        body.setCode(HttpStatus.BAD_REQUEST.value());
        body.setMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(body);
    }


}
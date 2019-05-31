package br.com.tilmais.springbootbrincandocomjpa.settings;

import br.com.tilmais.springbootbrincandocomjpa.dto.response.exceptions.BasicResponseForExceptions;
import br.com.tilmais.springbootbrincandocomjpa.dto.response.exceptions.ValidBindingResponseExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Calendar;

@ControllerAdvice
public class ProjectExceptionsHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(this.getValidBindingException(ex.getBindingResult()));
    }

    private ValidBindingResponseExceptions getValidBindingException(BindingResult errors) {
        ValidBindingResponseExceptions exception = new ValidBindingResponseExceptions(Calendar.getInstance());
        errors.getFieldErrors().forEach(fieldError -> exception.setErrorsBinding(fieldError.getField(), fieldError.getDefaultMessage()));
        return exception;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity handlerHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity
                .badRequest()
                .body(new BasicResponseForExceptions(Calendar.getInstance(), ex.getMessage().split(": ")[0]));
    }
}

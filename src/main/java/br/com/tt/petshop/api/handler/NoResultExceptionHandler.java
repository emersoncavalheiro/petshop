package br.com.tt.petshop.api.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NoResultException;

@ControllerAdvice
public class NoResultExceptionHandler {

    @ExceptionHandler(NoResultException.class)
    public ResponseEntity handler(NoResultException e){
        return ResponseEntity.notFound().build();
    }
}

package br.com.tt.petshop.api.handler;

import br.com.tt.petshop.exception.NomeInvalidoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class NomeInvalidoExceptionHandler {

    @ExceptionHandler(NomeInvalidoException.class)
    public ResponseEntity tratar(NomeInvalidoException e){
        ApiError error = new ApiError("nome_invalido" , e.getMessage(), LocalDateTime.now());

        return ResponseEntity.unprocessableEntity().body(error);

    }
}

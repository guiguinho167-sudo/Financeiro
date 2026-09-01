package com.controle.gastos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GastoErros {
    @ExceptionHandler(ErroException.class)
    public ResponseEntity<String> handlerErroException(ErroException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    public static class ErroException extends IllegalArgumentException {
        public ErroException(String message) {
            super(message);
        }
    }

    @ExceptionHandler(BuscasException.class)
    public ResponseEntity<String> handlerBuscasException(BuscasException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    public static class BuscasException extends RuntimeException {
        public BuscasException(String message) {
            super(message);
        }
    }

}

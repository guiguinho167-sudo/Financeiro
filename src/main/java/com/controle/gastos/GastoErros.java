package com.controle.gastos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GastoErros {
    @ExceptionHandler(ErroException.class)
    public ResponseEntity<String> handlerErroException(ErroException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    public class ErroException extends IllegalArgumentException {
        public ErroException(String message) {
            super(message);
        }
    }
}

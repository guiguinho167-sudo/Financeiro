package com.controle.gastos;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GastoController {
    private final GastoService gasto;

    @PostMapping
    public ResponseEntity<GastoResponse> criar(@RequestBody GastoResponse dados) {
        return ResponseEntity.ok(gasto.criar(dados));
    }

    @GetMapping
    public ResponseEntity<List<GastoResponse>> buscarlista() {
        return ResponseEntity.ok(gasto.buscarlista());
    }

}

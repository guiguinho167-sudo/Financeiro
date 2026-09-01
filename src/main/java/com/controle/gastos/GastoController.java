package com.controle.gastos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Usuario/v1")
@RequiredArgsConstructor
public class GastoController {
    private final GastoService gasto;

    @PostMapping("/salvo")
    public ResponseEntity<GastoResponse> criar(@Valid @RequestBody GastoRequest dados) {
        return ResponseEntity.ok(gasto.criar(dados));
    }

    @GetMapping("/buscarlista")
    public ResponseEntity<List<GastoResponse>> buscarlista() {
        return ResponseEntity.ok(gasto.buscarlista());
    }

    @GetMapping("/{gasto}/buscargastos")
    public ResponseEntity<GastoResponse> gastos(@PathVariable BigDecimal gastos) {
        return ResponseEntity.ok(gasto.gastos(gastos));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<GastoResponse> atualiza(@PathVariable Long id, @RequestBody GastoRequest dados) {
        return ResponseEntity.ok(gasto.atualiza(id, dados));
    }

    @DeleteMapping("/deleta")
    public Object delete(@PathVariable Long id) {
        return ResponseEntity.ok(gasto.delete(id));
    }

}

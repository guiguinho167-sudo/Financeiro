package com.controle.gastos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GastoService {
    private final GastoRepository repository;

    public GastoResponse criar(GastoResponse dados) {
        BigDecimal salario = dados.getSalario();
        BigDecimal gasto = dados.getGasto();

        BigDecimal saldofinal = salario.subtract(gasto);

        GastoDados gastos = new GastoDados();
        gastos.setSalario(salario);
        gastos.setGasto(gasto);

        GastoDados salva = new GastoDados();
        return new GastoResponse(salva.getId(), salva.getSalario(), salva.getGasto());
    }

    public List<GastoResponse> buscarlista() {
        return repository.findAll()
                .stream()
                .map(salvo -> new GastoResponse(salvo.getId(), salvo.getSalario(), salvo.getGasto()))
                .toList();
    }
}

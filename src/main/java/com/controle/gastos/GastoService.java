package com.controle.gastos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.controle.gastos.GastoErros.BuscasException;
import com.controle.gastos.GastoErros.ErroException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GastoService {
    private final GastoRepository repository;

    @Transactional
    public GastoResponse criar(GastoRequest dados) {
        BigDecimal salario = dados.getSalario();
        BigDecimal gasto = dados.getGasto();
        BigDecimal minimo = new BigDecimal("0.20");
        BigDecimal calcular = salario.subtract(gasto);
        BigDecimal porcentagem = calcular.multiply(minimo);

        if (calcular.compareTo(porcentagem) < 0) {
            throw new ErroException("Seu salario esta abixo de 20% ");
        }

        GastoDados gastos = new GastoDados();
        gastos.setSalario(salario);
        gastos.setGasto(gasto);

        GastoDados salva = repository.save(gastos);
        return new GastoResponse(salva.getId(), salva.getSalario(), salva.getGasto());

    }

    @Transactional
    public List<GastoResponse> buscarlista() {
        return repository.findAll()
                .stream()
                .map(salvo -> new GastoResponse(salvo.getId(), salvo.getSalario(), salvo.getGasto()))
                .toList();
    }

    @Transactional
    public GastoResponse gastos(BigDecimal gastos) {
        GastoDados salvo = repository.findByGasto(gastos)
                .orElseThrow(() -> new BuscasException("Usuario não encontrado"));
        return new GastoResponse(salvo.getId(), salvo.getSalario(), salvo.getGasto());
    }

    @Transactional
    public GastoResponse atualiza(Long id, GastoRequest dados) {
        GastoDados gastoDados = repository.findById(id)
                .orElseThrow(() -> new BuscasException("Usuario não encontrado"));

        gastoDados.setSalario(dados.getSalario());
        gastoDados.setGasto(dados.getGasto());

        GastoDados salvo = repository.save(gastoDados);
        return new GastoResponse(salvo.getId(), salvo.getSalario(), salvo.getGasto());
    }

    @Transactional
    public Object delete(Long id) {
        repository.deleteById(id);
        return "deletado";
    }
}

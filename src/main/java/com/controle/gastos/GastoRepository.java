package com.controle.gastos;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<GastoDados, Long> {
    Optional<GastoDados> findByGasto(BigDecimal gasto);
}

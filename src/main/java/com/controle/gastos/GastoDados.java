package com.controle.gastos;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.Column;
import lombok.Setter;

@Entity
@Table(name = "gastodados")
@Setter
@Getter
@RequiredArgsConstructor
public class GastoDados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "salario")
    private BigDecimal salario;
    @Column(name = "gasto")
    private BigDecimal gasto;

}
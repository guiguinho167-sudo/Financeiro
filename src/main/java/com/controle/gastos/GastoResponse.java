package com.controle.gastos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GastoResponse {
    private Long id;
    private BigDecimal salario;
    private BigDecimal gasto;

}
package com.controle.gastos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GastoRequest {
    @NotNull(message = "Salario não pode ser nulo")
    private BigDecimal salario;
    @NotNull(message = "Gasto não pode ser nulo")
    private BigDecimal gasto;
}

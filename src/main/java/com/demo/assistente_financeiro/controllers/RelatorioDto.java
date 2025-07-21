package com.demo.assistente_financeiro.controllers;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RelatorioDto {
    private BigDecimal saldoTotal;
    private BigDecimal entradas;
    private BigDecimal saidas;
    private Long transacoes;
}

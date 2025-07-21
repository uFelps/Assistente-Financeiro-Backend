package com.demo.assistente_financeiro.dto;

import com.demo.assistente_financeiro.enums.TipoTransacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class TransacaoDto {

    private UUID id;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 3, max = 100, message = "A descrição deve ter entre 3 e 100 caracteres")
    private String descricao;

    @NotNull(message = "O valor é obrigatório")
    private BigDecimal valor;

    private LocalDateTime dataHora;

    @NotNull(message = "O tipo de transação é obrigatório")
    private TipoTransacao tipoTransacao;

    @NotNull(message = "A categoria é obrigatória")
    private String categoria;
}

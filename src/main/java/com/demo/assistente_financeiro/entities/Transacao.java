package com.demo.assistente_financeiro.entities;

import com.demo.assistente_financeiro.enums.TipoTransacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transacoes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String descricao;
    private BigDecimal valor;
    private LocalDateTime dataHora;
    @Enumerated(EnumType.STRING)
    private TipoTransacao tipoTransacao;
    private String categoria;

}

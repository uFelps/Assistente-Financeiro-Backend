package com.demo.assistente_financeiro.repositories;

import com.demo.assistente_financeiro.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {

    @Query("SELECT SUM(t.valor) FROM Transacao t")
    Optional<BigDecimal> calcularSaldoTotal();

    @Query("SELECT SUM(t.valor) FROM Transacao t WHERE t.tipoTransacao = 'ENTRADA'")
    Optional<BigDecimal> calcularEntradas();

    @Query("SELECT SUM(t.valor) FROM Transacao t WHERE t.tipoTransacao = 'SAIDA'")
    Optional<BigDecimal> calcularSaidas();

}

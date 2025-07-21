package com.demo.assistente_financeiro.services;

import com.demo.assistente_financeiro.controllers.RelatorioDto;
import com.demo.assistente_financeiro.dto.TransacaoDto;
import com.demo.assistente_financeiro.entities.Transacao;
import com.demo.assistente_financeiro.repositories.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public Page<TransacaoDto> listarTransacoes(Pageable pageable) {

        return transacaoRepository.findAll(pageable).map(this::entityToDto);
    }

    public void criarTransacao(TransacaoDto transacaoDto) {
        Transacao transacao = dtoToEntity(transacaoDto);
        transacao.setDataHora(LocalDateTime.now());
        transacaoRepository.save(transacao);
    }

    public RelatorioDto buscarRelatorio() {

        BigDecimal saldoTotal = transacaoRepository.calcularSaldoTotal().orElse(BigDecimal.ZERO);
        BigDecimal entradas = transacaoRepository.calcularEntradas().orElse(BigDecimal.ZERO);
        BigDecimal saidas = transacaoRepository.calcularSaidas().orElse(BigDecimal.ZERO);
        Long transacoes = transacaoRepository.count();


        return RelatorioDto.builder()
                .saldoTotal(saldoTotal)
                .entradas(entradas)
                .saidas(saidas)
                .transacoes(transacoes)
                .build();
    }

    private Transacao dtoToEntity(TransacaoDto transacaoDto) {
        return Transacao.builder()
                .id(transacaoDto.getId())
                .descricao(transacaoDto.getDescricao())
                .valor(transacaoDto.getValor())
                .dataHora(transacaoDto.getDataHora())
                .tipoTransacao(transacaoDto.getTipoTransacao())
                .categoria(transacaoDto.getCategoria())
                .build();
    }

    private TransacaoDto entityToDto(Transacao transacao) {
        return TransacaoDto.builder()
                .id(transacao.getId())
                .descricao(transacao.getDescricao())
                .valor(transacao.getValor())
                .dataHora(transacao.getDataHora())
                .tipoTransacao(transacao.getTipoTransacao())
                .categoria(transacao.getCategoria())
                .build();
    }
}

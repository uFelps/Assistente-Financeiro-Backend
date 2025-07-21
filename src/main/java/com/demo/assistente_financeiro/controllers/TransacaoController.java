package com.demo.assistente_financeiro.controllers;

import com.demo.assistente_financeiro.services.TransacaoService;
import com.demo.assistente_financeiro.dto.TransacaoDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<Page<TransacaoDto>> listarTransacoes(Pageable pageable) {
        return ResponseEntity.ok(transacaoService.listarTransacoes(pageable));
    }

    @GetMapping("/relatorio")
    public ResponseEntity<RelatorioDto> buscarRelatorio(){
        return ResponseEntity.ok(transacaoService.buscarRelatorio());
    }

    @PostMapping
    public ResponseEntity<Void> criarTransacao(@RequestBody @Valid TransacaoDto transacaoDto) {

        transacaoService.criarTransacao(transacaoDto);
        return ResponseEntity.noContent().build();
    }
}

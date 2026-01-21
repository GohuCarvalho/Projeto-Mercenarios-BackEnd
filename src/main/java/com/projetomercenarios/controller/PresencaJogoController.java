package com.projetomercenarios.controller;


import com.projetomercenarios.dto.PresencaDTO;
import com.projetomercenarios.entity.Partida;
import com.projetomercenarios.entity.PresencaJogo;
import com.projetomercenarios.service.PresencaJogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presenca")
public class PresencaJogoController {

    @Autowired
    private PresencaJogoService presencaJogoService;

    @GetMapping
    public ResponseEntity<List<PresencaJogo>> listar() {
        return ResponseEntity.ok(presencaJogoService.listarPresencaJogo());
    }

    @GetMapping("/{id}")
    public PresencaJogo listarPresencaId(@PathVariable Long id) {
        return presencaJogoService.ListarPresencaId(id);
    }

    @PostMapping
    public ResponseEntity<PresencaDTO> registrar(@RequestBody PresencaJogo presenca) {
        PresencaDTO novoDto = presencaJogoService.registrar(presenca);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PresencaDTO> atualizarPresenca(@PathVariable Long id,@RequestBody PresencaJogo dadosAtualizados) {
        PresencaDTO dto = presencaJogoService.atualizar(id, dadosAtualizados);
        return ResponseEntity.ok(dto);
    }
}

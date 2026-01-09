package com.projetomercenarios.controller;


import com.projetomercenarios.entity.Jogador;
import com.projetomercenarios.service.JogadorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogador")
public class JogadorController {

    @Autowired
    JogadorService jogadorService;

    @GetMapping
    public ResponseEntity<List<Jogador>> listar(){
        return ResponseEntity.ok(jogadorService.findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Jogador> criar (@RequestBody Jogador jogador) {
        Jogador novoJogador = jogadorService.criar(jogador);
        return ResponseEntity.ok(novoJogador);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Jogador> atualizar(@PathVariable Long id, @RequestBody Jogador jogador) {
        Jogador atualizado = jogadorService.atualizar(id, jogador);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        jogadorService.deletar(id);

        return ResponseEntity.noContent().build();
    }


}

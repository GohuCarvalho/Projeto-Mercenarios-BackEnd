package com.projetomercenarios.controller;

import com.projetomercenarios.entity.Partida;
import com.projetomercenarios.service.PartidaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partida")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @GetMapping
    public List<Partida> listar() {
        return partidaService.listarTodasPartidas();
    }

    @GetMapping("/{id}")
    public List<Partida> listarTodasPartidas() {
        return partidaService.listarTodasPartidas();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Partida> criar(@RequestBody Partida partida) {
        return ResponseEntity.ok(partidaService.inserir(partida));
    }

}

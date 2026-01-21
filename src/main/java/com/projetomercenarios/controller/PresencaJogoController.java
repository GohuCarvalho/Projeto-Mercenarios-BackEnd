package com.projetomercenarios.controller;


import com.projetomercenarios.entity.PresencaJogo;
import com.projetomercenarios.service.PresencaJogoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public ResponseEntity<PresencaJogo> registrar(@RequestBody PresencaJogo presenca) {
        PresencaJogo novaPresenca = presencaJogoService.registrar(presenca);
        return ResponseEntity.ok(novaPresenca);
    }
}

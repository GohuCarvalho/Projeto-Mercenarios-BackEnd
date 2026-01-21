package com.projetomercenarios.service;


import com.projetomercenarios.entity.Partida;
import com.projetomercenarios.enums.ResultadoEnum;
import com.projetomercenarios.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<Partida> listarTodasPartidas() {
        return partidaRepository.findAll();
    }

    public Partida ListarPartida(Long id) {
    return partidaRepository.findById(id)
           .orElseThrow(() -> new RuntimeException("Partida não encontrada"));
    }

    public Partida inserir(Partida partida) {
        if (partida.getGolsTimeA() > partida.getGolsTimeB()) {
            partida.setResultado(ResultadoEnum.VITORIA);
        } else if (partida.getGolsTimeA() < partida.getGolsTimeB()) {
            partida.setResultado(ResultadoEnum.DERROTA);
        } else {
            partida.setResultado(ResultadoEnum.EMPATE);
        }
        return partidaRepository.save(partida);
    }


}

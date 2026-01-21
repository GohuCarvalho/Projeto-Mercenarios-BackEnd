package com.projetomercenarios.service;

import com.projetomercenarios.dto.PresencaDTO;
import com.projetomercenarios.entity.Jogador;
import com.projetomercenarios.entity.Partida;
import com.projetomercenarios.entity.PresencaJogo;
import com.projetomercenarios.enums.TipoPresencaEnum;
import com.projetomercenarios.repository.JogadorRepository;
import com.projetomercenarios.repository.PartidaRepository;
import com.projetomercenarios.repository.PresencaJogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresencaJogoService {

    @Autowired
    private PresencaJogoRepository presencaRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    public List<PresencaJogo> listarPresencaJogo() {
        return presencaRepository.findAll();
    }

    public PresencaJogo ListarPresencaId(Long id) {
        return presencaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registros de presença não encontrada"));
    }

    public PresencaDTO registrar(PresencaJogo presenca) {
        Jogador jogador = jogadorRepository.findById(presenca.getJogador().getId())
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        Partida partida = partidaRepository.findById(presenca.getPartida().getId())
                .orElseThrow(() -> new RuntimeException("Partida não encontrada"));

        presenca.setJogador(jogador);
        presenca.setPartida(partida);
        TipoPresencaEnum tipo = presenca.getTipoPresenca();
        presenca.setPontosCalculados(tipo.getPontos());

        PresencaJogo salva = presencaRepository.save(presenca);

        return new PresencaDTO(
                salva.getId(),
                jogador.getApelido(),
                salva.getPontosCalculados(),
                salva.getGols(),
                salva.getApitou(),
                salva.getAgarrou()
        );
    }

    public PresencaDTO atualizar(Long id, PresencaJogo dadosAtualizados) {

        PresencaJogo presencaJogoExistente = presencaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registros de presença não encontrados"));

        if (dadosAtualizados.getTipoPresenca() != null) {
            presencaJogoExistente.setTipoPresenca(dadosAtualizados.getTipoPresenca());
        }

        if (dadosAtualizados.getAssistencias() != null) {
            presencaJogoExistente.setAssistencias(dadosAtualizados.getAssistencias());
        }

        if(dadosAtualizados.getGols() != null) {
            presencaJogoExistente.setGols(dadosAtualizados.getGols());
        }
        if (dadosAtualizados.getApitou() != null) {
            presencaJogoExistente.setApitou(dadosAtualizados.getApitou());
        }

        if (dadosAtualizados.getAgarrou() != null) {
            presencaJogoExistente.setAgarrou(dadosAtualizados.getAgarrou());
        }

        PresencaJogo presencaAtualizada = presencaRepository.save(presencaJogoExistente);

        return new PresencaDTO(
                presencaAtualizada.getId(),
                presencaAtualizada.getJogador().getApelido(),
                presencaAtualizada.getPontosCalculados(),
                presencaAtualizada.getGols(),
                presencaAtualizada.getApitou(),
                presencaAtualizada.getAgarrou()
        );

    }
    }

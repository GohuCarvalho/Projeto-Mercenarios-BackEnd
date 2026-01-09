package com.projetomercenarios.service;


import com.projetomercenarios.entity.Jogador;
import com.projetomercenarios.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    JogadorRepository jogadorRepository;


    public List<Jogador> findAll() {
        return jogadorRepository.findAll();
    }

    public Jogador criar (Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public Jogador atualizar(Long id, Jogador dadosAtualizados) {

        Jogador jogadorExistente = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        if (dadosAtualizados.getNome() != null) {
            jogadorExistente.setNome(dadosAtualizados.getNome());
        }
        if (dadosAtualizados.getApelido() != null) {
            jogadorExistente.setApelido(dadosAtualizados.getApelido());
        }
        if (dadosAtualizados.getTelefone() != null) {
            jogadorExistente.setTelefone(dadosAtualizados.getTelefone());
        }
        if (dadosAtualizados.getEmail() != null) {
            jogadorExistente.setEmail(dadosAtualizados.getEmail());
        }
        return jogadorRepository.save(jogadorExistente);
    }

    public void deletar (Long id) {
        if(!jogadorRepository.existsById(id)){
            throw new RuntimeException("Jogador não encontrado");
        }
        jogadorRepository.deleteById(id);
    }
}

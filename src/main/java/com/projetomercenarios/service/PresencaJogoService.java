package com.projetomercenarios.service;

import com.projetomercenarios.entity.PresencaJogo;
import com.projetomercenarios.enums.TipoPresencaEnum;
import com.projetomercenarios.repository.PartidaRepository;
import com.projetomercenarios.repository.PresencaJogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresencaJogoService {

    @Autowired
    private PresencaJogoRepository presencaRepository;

    public List<PresencaJogo> listarPresencaJogo() {
        return presencaRepository.findAll();
    }

    public PresencaJogo registrar(PresencaJogo presenca) {
        TipoPresencaEnum tipo = presenca.getTipoPresenca();
        presenca.setPontosCalculados(tipo.getPontos());
        return presencaRepository.save(presenca);
    }

}

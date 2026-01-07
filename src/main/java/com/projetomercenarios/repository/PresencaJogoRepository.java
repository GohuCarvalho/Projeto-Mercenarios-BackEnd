package com.projetomercenarios.repository;

import com.projetomercenarios.entity.PresencaJogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresencaJogoRepository extends JpaRepository<PresencaJogo, Long> {

    boolean existsByJogadorIdAndPartidaId(Long jogadorId, Long partidaId);

    List<PresencaJogo> findByPartidaId(Long partidaId);

    List<PresencaJogo> findByJogadorId(Long jogadorId);
}


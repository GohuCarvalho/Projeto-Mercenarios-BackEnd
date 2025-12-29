package com.projetomercenarios.repository;


import com.projetomercenarios.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository <Jogador, Long> {

}

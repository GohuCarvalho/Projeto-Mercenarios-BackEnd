package com.projetomercenarios.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "temporada")
public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_temporada")
    private Long idTemporada;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private Integer trimestre;

    private String descricao;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    public Long getIdTemporada() {
        return idTemporada;
    }

    public void setIdTemporada(Long idTemporada) {
        this.idTemporada = idTemporada;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Integer trimestre) {
        this.trimestre = trimestre;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}

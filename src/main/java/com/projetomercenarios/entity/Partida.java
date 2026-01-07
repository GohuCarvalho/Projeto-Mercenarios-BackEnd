package com.projetomercenarios.entity;

import com.projetomercenarios.enums.ClimaEnum;
import com.projetomercenarios.enums.ResultadoEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "partida")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataJogo;

    @Enumerated(EnumType.STRING)
    private ClimaEnum clima;

    private Integer golsTimeA;
    private Integer golsTimeB;

    @Enumerated(EnumType.STRING)
    private ResultadoEnum resultado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(LocalDate dataJogo) {
        this.dataJogo = dataJogo;
    }

    public ClimaEnum getClima() {
        return clima;
    }

    public void setClima(ClimaEnum clima) {
        this.clima = clima;
    }

    public Integer getGolsTimeA() {
        return golsTimeA;
    }

    public void setGolsTimeA(Integer golsTimeA) {
        this.golsTimeA = golsTimeA;
    }

    public Integer getGolsTimeB() {
        return golsTimeB;
    }

    public void setGolsTimeB(Integer golsTimeB) {
        this.golsTimeB = golsTimeB;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }
}

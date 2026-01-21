package com.projetomercenarios.dto;

public class PresencaDTO {

    private Long id;
    private String apelido;
    private Integer pontos;
    private Integer gols;
    private Boolean apitou;
    private Boolean agarrou;

    public PresencaDTO(Long id, String apelido, Integer pontos, Integer gols, Boolean apitou, Boolean agarrou) {
        this.id = id;
        this.apelido = apelido;
        this.pontos = pontos;
        this.gols = gols;
        this.apitou = apitou;
        this.agarrou = agarrou;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Integer getGols() {
        return gols;
    }

    public void setGols(Integer gols) {
        this.gols = gols;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Boolean getApitou() {
        return apitou;
    }

    public void setApitou(Boolean apitou) {
        this.apitou = apitou;
    }

    public Boolean getAgarrou() {
        return agarrou;
    }

    public void setAgarrou(Boolean agarrou) {
        this.agarrou = agarrou;
    }
}

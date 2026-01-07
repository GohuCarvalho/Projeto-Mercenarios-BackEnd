package com.projetomercenarios.enums;

public enum TipoPresencaEnum {
    PV(3),
    PD(2),
    PE(2),
    PVC(4),
    PDC(3),
    PEC(3),
    PL(1),
    PLC(2),
    PSA(0),
    FJ(0),
    FNJ(-2),
    CF(-3);

    private final int pontos;

    TipoPresencaEnum(int pontos) {
        this.pontos = pontos;
    }

    public int getPontos() {
        return pontos;
    }
}

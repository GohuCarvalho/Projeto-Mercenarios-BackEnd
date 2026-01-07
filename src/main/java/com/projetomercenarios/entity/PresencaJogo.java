package com.projetomercenarios.entity;

import com.projetomercenarios.enums.ResultadoEnum;
import com.projetomercenarios.enums.TipoPresencaEnum;
import jakarta.persistence.*;

@Entity
@Table(
        name = "presenca_jogo",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id_jogador", "id_partida"})
        }
)
public class PresencaJogo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(optional = false)
        @JoinColumn(name = "id_jogador")
        private Jogador jogador;

        @ManyToOne(optional = false)
        @JoinColumn(name = "id_partida")
        private Partida partida;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private TipoPresencaEnum tipoPresenca;

        private boolean apitou;
        private boolean agarrou;

        private Integer pontosCalculados;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Jogador getJogador() {
                return jogador;
        }

        public void setJogador(Jogador jogador) {
                this.jogador = jogador;
        }

        public Partida getPartida() {
                return partida;
        }

        public void setPartida(Partida partida) {
                this.partida = partida;
        }

        public TipoPresencaEnum getTipoPresenca() {
                return tipoPresenca;
        }

        public void setTipoPresenca(TipoPresencaEnum tipoPresenca) {
                this.tipoPresenca = tipoPresenca;
        }

        public boolean isApitou() {
                return apitou;
        }

        public void setApitou(boolean apitou) {
                this.apitou = apitou;
        }

        public boolean isAgarrou() {
                return agarrou;
        }

        public void setAgarrou(boolean agarrou) {
                this.agarrou = agarrou;
        }

        public Integer getPontosCalculados() {
                return pontosCalculados;
        }

        public void setPontosCalculados(Integer pontosCalculados) {
                this.pontosCalculados = pontosCalculados;
        }
}

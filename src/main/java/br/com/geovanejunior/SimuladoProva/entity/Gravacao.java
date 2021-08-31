package br.com.geovanejunior.SimuladoProva.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_gravacao")
public class Gravacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codGravacao;

    private LocalDate dataGravacao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codGravadora")
    private Gravadora gravadora;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codCantor")
    private Cantor cantor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codMusica")
    private Musica musica;

    public Gravacao() {
    }

    public Gravacao(LocalDate dataGravacao, Gravadora gravadora, Cantor cantor, Musica musica) {
        this.dataGravacao = dataGravacao;
        this.gravadora = gravadora;
        this.cantor = cantor;
        this.musica = musica;
    }

    public Long getCodGravacao() {
        return codGravacao;
    }

    public void setCodGravacao(Long codGravacao) {
        this.codGravacao = codGravacao;
    }

    public LocalDate getDataGravacao() {
        return dataGravacao;
    }

    public void setDataGravacao(LocalDate dataGravacao) {
        this.dataGravacao = dataGravacao;
    }

    public Gravadora getGravadora() {
        return gravadora;
    }

    public void setGravadora(Gravadora gravadora) {
        this.gravadora = gravadora;
    }

    public Cantor getCantor() {
        return cantor;
    }

    public void setCantor(Cantor cantor) {
        this.cantor = cantor;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setMusica(Musica musica) {
        this.musica = musica;
    }
}

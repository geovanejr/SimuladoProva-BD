package br.com.geovanejunior.SimuladoProva.entity;

import br.com.geovanejunior.SimuladoProva.entity.enums.Pais;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_gravadoras")
public class Gravadora implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codGravadora;

    @Column(length = 50, nullable = false)
    private String nomeGravadora;

    private Integer codPais;

    public Gravadora() {
    }

    public Gravadora(String nomeGravadora, Pais pais) {
        this.nomeGravadora = nomeGravadora;
        this.codPais = (pais == null) ? null : pais.getCodPais();
    }

    public Long getCodGravadora() {
        return codGravadora;
    }

    public void setCodGravadora(Long codGravadora) {
        this.codGravadora = codGravadora;
    }

    public String getNomeGravadora() {
        return nomeGravadora;
    }

    public void setNomeGravadora(String nomeGravadora) {
        this.nomeGravadora = nomeGravadora;
    }

    public Integer getCodPais() {
        return codPais;
    }

    public void setCodPais(Integer codPais) {
        this.codPais = codPais;
    }
}

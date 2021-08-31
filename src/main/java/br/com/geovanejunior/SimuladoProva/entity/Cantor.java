package br.com.geovanejunior.SimuladoProva.entity;

import br.com.geovanejunior.SimuladoProva.entity.enums.Pais;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_cantores")
public class Cantor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCantor;

    @Column(length = 50, nullable = false)
    private String nomeCantor;

    private Integer codPais;

    public Cantor() {
    }

    public Cantor(String nomeCantor, Pais pais) {
        this.nomeCantor = nomeCantor;
        this.codPais = (pais == null) ? null : pais.getCodPais();;
    }

    public Long getCodCantor() {
        return codCantor;
    }

    public void setCodCantor(Long codCantor) {
        this.codCantor = codCantor;
    }

    public String getNomeCantor() {
        return nomeCantor;
    }

    public void setNomeCantor(String nomeCantor) {
        this.nomeCantor = nomeCantor;
    }

    public Integer getCodPais() {
        return codPais;
    }

    public void setCodPais(Integer codPais) {
        this.codPais = codPais;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cantor{");
        sb.append("codCantor=").append(codCantor);
        sb.append(", nomeCantor='").append(nomeCantor).append('\'');
        sb.append(", codPais=").append(codPais);
        sb.append(", descPais=").append(Pais.toEnum(codPais));
        sb.append('}');
        return sb.toString();
    }
}

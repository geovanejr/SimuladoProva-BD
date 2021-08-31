package br.com.geovanejunior.SimuladoProva.entity;

import br.com.geovanejunior.SimuladoProva.entity.enums.TipoTelefone;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_telefones")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codFone;

    @Column(length = 80)
    private String numero;

    @Column(length = 1)
    private Character tipoTelefone;

    @ManyToOne
    @JoinColumn(name="codPessoa", nullable = false)
    @JsonBackReference
    private Pessoa pessoa;

    public Telefone() {
    }

    public Telefone(Long codFone, String numero, TipoTelefone tipoTelefone, Pessoa pessoa) {
        this.codFone = codFone;
        this.numero = numero;
        this.tipoTelefone = (tipoTelefone == null) ? null : tipoTelefone.getTipoTelefone();
        this.pessoa = pessoa;
    }

    public Long getCodFone() {
        return codFone;
    }

    public void setCodFone(Long codFone) {
        this.codFone = codFone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Character getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(Character tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Telefone{");
        sb.append("codFone=").append(codFone);
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", tipoTelefone=").append(TipoTelefone.toEnum(tipoTelefone));
        sb.append('}');
        return sb.toString();
    }
}

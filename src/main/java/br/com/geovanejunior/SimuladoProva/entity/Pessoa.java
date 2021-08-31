package br.com.geovanejunior.SimuladoProva.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_pessoas")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private Long codPessoa;

    @Column(length = 70, nullable = false)
    private String nomePessoa;

    @OneToMany(mappedBy = "pessoa", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Telefone> telefones = new ArrayList<>();

    public Pessoa() {
    }

    public Pessoa(String nomePessoa) {

        this.nomePessoa = nomePessoa;
    }

    public Long getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(Long codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pessoa{");
        sb.append("codPessoa=").append(codPessoa);
        sb.append(", nomePessoa='").append(nomePessoa).append('\'');
        sb.append(", telefones=").append(telefones);
        sb.append('}');
        return sb.toString();
    }
}

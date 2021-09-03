package br.com.geovanejunior.SimuladoProva.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_categorias")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCategoria;

    @Column(length = 50)
    private String descCategoria;

    public Categoria() {
    }

    public Categoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    public Long getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(Long codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }
}

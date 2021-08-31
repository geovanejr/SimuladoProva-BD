package br.com.geovanejunior.SimuladoProva.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_musicas")
@NamedEntityGraph(
        name = "musica-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("duracao")
        }
)
public class Musica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codMusica;

    private Integer duracao;

    @Column(length = 100)
    private String titulo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codCategoria", referencedColumnName = "codCategoria", nullable = false)
    private Categoria categoria;


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "codCategoria", referencedColumnName = "codCategoria", nullable = false)
//    @JsonBackReference
//    private Categoria categoria;

    public Musica() {
    }

    public Musica(Integer duracao, String titulo, Categoria categoria) {
        this.duracao = duracao;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public Long getCodMusica() {
        return codMusica;
    }

    public void setCodMusica(Long codMusica) {
        this.codMusica = codMusica;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

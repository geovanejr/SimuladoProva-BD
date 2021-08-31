package br.com.geovanejunior.SimuladoProva.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_departamentos")
@Data
//public class Departamento extends AbstractPersistable<Long> {
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nomeDepartamento;

    public Departamento() {

    }

    public Departamento(String nomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }

    @Override
    public String toString() {
        return "Departamento: {" +
                "id = " + getId() +
                ", Descrição = '" + getNomeDepartamento() + '\'' +
                '}';
    }
}

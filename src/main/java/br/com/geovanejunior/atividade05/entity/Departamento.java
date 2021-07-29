package br.com.geovanejunior.atividade05.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_departamentos")
@Data
public class Departamento extends AbstractPersistable<Long> {
//public class Departamento {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

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

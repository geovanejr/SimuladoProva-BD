package br.com.geovanejunior.atividade05.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;

@Entity
@Table(name="tb_funcionarios")
@Data
@SequenceGenerator(name="sequence_id_func", sequenceName = "sequence_func", initialValue = 1)
public class Funcionario extends AbstractPersistable<Long> {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;

    @Column(length = 100, nullable = false)
    private String nomeFuncionario;

    @Column(nullable = false)
    private Integer qtdeDependente;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Float salFuncionario;

    @Column(length = 30, nullable = false)
    private String nomeCargo;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    public Funcionario() {

    }

    public Funcionario(String nomeFuncionario, Integer qtdeDependente, Float salFuncionario, String nomeCargo, Departamento departamento) {

        this.nomeFuncionario = nomeFuncionario;
        this.qtdeDependente = qtdeDependente;
        this.salFuncionario = salFuncionario;
        this.nomeCargo = nomeCargo;
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + getId() +
                ", nomeFuncionario='" + nomeFuncionario + '\'' +
                ", qtdeDependente=" + qtdeDependente +
                ", salFuncionario=" + salFuncionario +
                ", nomeCargo='" + nomeCargo + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}

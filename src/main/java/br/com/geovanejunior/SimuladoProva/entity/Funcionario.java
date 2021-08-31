package br.com.geovanejunior.SimuladoProva.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_funcionarios")
@Data
@NamedQuery(
        name = "Funcionario.byqtdeDep",
        query = "select f from Funcionario f where f.qtdeDep = ?1"
)
@NamedNativeQuery(
        name = "Funcionario.byParteNome",
        query = "select * from tb_funcionarios where nome like CONCAT('%',?1,'%')",
        resultClass = Funcionario.class
)
@NamedStoredProcedureQuery(
        name = "Funcionario.UpdSal",
        procedureName = "procedure_updSalario",
        parameters = {
                @StoredProcedureParameter(
                        mode = ParameterMode.IN,
                        name = "percAumento",
                        type = Integer.class
                )
        }
)
//public class Funcionario extends AbstractPersistable<Long> {
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer qtdeDep;

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

        this.nome = nomeFuncionario;
        this.qtdeDep = qtdeDependente;
        this.salFuncionario = salFuncionario;
        this.nomeCargo = nomeCargo;
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + getId() +
                ", nomeFuncionario='" + nome + '\'' +
                ", qtdeDependente=" + qtdeDep +
                ", salFuncionario=" + salFuncionario +
                ", nomeCargo='" + nomeCargo + '\'' +
                ", departamento=" + departamento +
                '}';
    }
}

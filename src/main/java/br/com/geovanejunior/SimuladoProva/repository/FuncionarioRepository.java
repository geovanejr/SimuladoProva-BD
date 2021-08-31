package br.com.geovanejunior.SimuladoProva.repository;

import br.com.geovanejunior.SimuladoProva.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    // Listar um funcionário pelo seu nome e quantidade de dependentes utilizando consulta
    // por palavras-chaves
    Funcionario findByNomeAndQtdeDep(String nome, Integer qtdeDep);

    // Listar todos os funcionários de um determinado departamento por JPQL via @Query.
    List<Funcionario> findByDepartamento_Id(Long departamento_id);

    // Consultar o primeiro funcionário que tem o maior salário
    Funcionario findTopByOrderBySalFuncionarioDesc();

    // Listar os 3 (três) primeiros funcionários que tem os maiores salários.
    List<Funcionario> findFirst3ByOrderBySalFuncionarioDesc();

    // Listar os funcionários que não tem dependentes em ordem crescente de nome por JPQL
    // via @Query
    @Query("select f from Funcionario f where f.qtdeDep = 0 order by f.nome asc ")
    List<Funcionario> findFuncionarioWithoutDependente();

    // Listar os funcionários que tem salário maior que um determinado valor por JPQL
    // sobrescrevendo palavras-chaves @Query.
    @Query("select f from Funcionario f where f.salFuncionario > ?1")
    List<Funcionario> listFuncionarioBySalario(Float salFuncionario);

    // Listar os funcionários que tem salário maior que um determinado valor por @Query
    // com native query
    @Query(value = "Select * from tb_funcionarios where salFuncionario > ?1", nativeQuery = true)
    public List<Funcionario> listFuncionarioBySalarioNativeQuery(Float salFuncionario);

    // Lista os funcionários com uma determinada quantidade de dependentes por @NamedQuery.
    @Query(name = "Funcionario.byqtdeDep")
    public List<Funcionario> listFuncionarioByQtdeDep(Integer qtdeDep);

    // Lista os funcionários que contenham em qualquer parte do seu nome um determinado nome por
    // @NamedNativeQuery
    @Query(name = "Funcionario.byParteNome")
    public List<Funcionario> listByParteNome(@Param("keyword") String nome);

    // Uma consulta que lista todos os funcionários de um determinado departamento
    // que não possuam dependentes utilizando parâmetros nomeados.

    @Query("Select fun from Funcionario fun where fun.departamento.id = :id_depart" +
            "  and fun.qtdeDep = 0")
    public List<Funcionario> listFuncionarioWithoutDepend(@Param("id_depart") Long departamento_id);

    // Procedure que aumenta o salário de todos os funcionários em X porcento,
    // onde X é um número inteiro.
    @Procedure(procedureName = "procedure_updSalario")
    void procedureUpdateSalario(Integer percAumento);

    // Instrução com anotação @Modifing e instrução update que troca todos os funcionários de um determinado
    // departamento para outro departamento utilizando a anotação @Modifying.
    @Transactional
    @Modifying
    @Query("Update Funcionario func " +
            "  set func.departamento.id = ?2 " +
            "where func.departamento.id = ?1")
    void updateFuncionarioByDepartamento(Long oldDepart_id, Long newDepart_id);

    // Instrução com anotação @Modifing e instrução delete que exclui todos os funcionários de um determinado
    // departamento utilizando a anotação @Modifying.
    @Transactional
    @Modifying
    @Query("Delete from Funcionario func where func.departamento.id = ?1")
    void deleteFuncionarioByDepartamento(Long departamento_id);
}

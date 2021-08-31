package br.com.geovanejunior.SimuladoProva.service;

import br.com.geovanejunior.SimuladoProva.entity.Funcionario;
import br.com.geovanejunior.SimuladoProva.repository.FuncionarioRepository;
import br.com.geovanejunior.SimuladoProva.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repFunc;

    public List<Funcionario> findAll() {

        return repFunc.findAll();
    }

//    public Optional<Funcionario> findById(Long id) {
    public Funcionario findById(Long id) {

        Optional<Funcionario> func = repFunc.findById(id);

        return func.orElseThrow(() -> new ObjectNotFoundException(
               "Funcionario não encontrado. Id: " + id + ", Tipo: " + Funcionario.class.getName()));
    }

    public void save(Funcionario funcionario) {

        repFunc.save(funcionario);
    }

    public Funcionario findByNomeAndQtdeDep(String nome, Integer qtdeDep) {

        return repFunc.findByNomeAndQtdeDep(nome, qtdeDep);
    }

    // Listar todos os funcionários de um determinado departamento por JPQL via @Query.
    public List<Funcionario> findByDepartamentoId(Long departamentoId) {

        return repFunc.findByDepartamento_Id(departamentoId);
    }

    // Consultar o primeiro funcionário que tem o maior salário
    public Funcionario findTopByOrderBySalFuncionarioDesc() {

        return repFunc.findTopByOrderBySalFuncionarioDesc();
    }

    public List<Funcionario> findFirst3ByOrderBySalFuncionarioDesc() {

        return repFunc.findFirst3ByOrderBySalFuncionarioDesc();
    }

    public  List<Funcionario> findFuncionarioWithoutDependente() {

        return repFunc.findFuncionarioWithoutDependente();
    }

    // Listar os funcionários que tem salário maior que um determinado valor por JPQL
    // sobrescrevendo palavras-chaves @Query.
    public List<Funcionario> listFuncionarioBySalario(Float salFuncionario) {

        return repFunc.listFuncionarioBySalario(salFuncionario);
    }

    // Listar os funcionários que tem salário maior que um determinado valor por @Query
    // com native query

    public List<Funcionario> listFuncionarioBySalarioNativeQuery(Float salFuncionario) {

        return repFunc.listFuncionarioBySalarioNativeQuery(salFuncionario);
    };


    // Lista os funcionários com uma determinada quantidade de dependentes por @NamedQuery.

    public List<Funcionario> listFuncionarioByQtdeDep(Integer qtdeDep) {

        return repFunc.listFuncionarioByQtdeDep(qtdeDep);
    }

    // Lista os funcionários que contenham em qualquer parte do seu nome um determinado nome por
    // @NamedNativeQuery

    public List<Funcionario> listByParteNome(String nome) {

        return repFunc.listByParteNome(nome);
    }

    // Uma consulta que lista todos os funcionários de um determinado departamento
    // que não possuam dependentes utilizando parâmetros nomeados.
    public List<Funcionario> listFuncionarioWithoutDepend(Long departamento_id) {

        return repFunc.listFuncionarioWithoutDepend(departamento_id);
    }

    // Método que aumenta o salário de todos os funcionários em X porcento,
    // onde X é um número inteiro.
    public void procedureUpdateSalario(Integer percAumento) {

        repFunc.procedureUpdateSalario(percAumento);
    }

    // Instrução com anotação @Modifing e instrução update que troca todos os funcionários de um determinado
    // departamento para outro departamento utilizando a anotação @Modifying.
    public void updateFuncionarioByDepartamento(Long oldDepart_id, Long newDepart_id) {

        repFunc.updateFuncionarioByDepartamento(oldDepart_id, newDepart_id);
    }
    // Instrução com anotação @Modifing e instrução delete que exclui todos os funcionários de um determinado
    // departamento utilizando a anotação @Modifying.
    public void deleteFuncionarioByDepartamento(Long departamento_id) {

        repFunc.deleteFuncionarioByDepartamento(departamento_id);
    }
}

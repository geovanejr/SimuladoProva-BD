package br.com.geovanejunior.SimuladoProva.resource;

import br.com.geovanejunior.SimuladoProva.entity.Funcionario;
import br.com.geovanejunior.SimuladoProva.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcService;

    @RequestMapping(value = "/departamento/{departamentoId}")
    public ResponseEntity<List<Funcionario>> findByDepartamentoId(@PathVariable Long departamentoId) {

        List<Funcionario> funcionario = funcService.findByDepartamentoId(departamentoId);

        return ResponseEntity.ok().body(funcionario);
    }

    @RequestMapping(value="/nome")
    public ResponseEntity<Funcionario> findByNomeAndDepend(@RequestParam(name="nome") String nome, @RequestParam (name = "depend") Integer qtdeDepend) {

        Funcionario funcionario = funcService.findByNomeAndQtdeDep(nome, qtdeDepend);

        return ResponseEntity.ok().body(funcionario);
    }

    // Consultar o primeiro funcionário que tem o maior salário
    @RequestMapping(value="/saldesc")
    public ResponseEntity<Funcionario> findTopByOrderBySalFuncionarioDesc() {

        Funcionario funcionario = funcService.findTopByOrderBySalFuncionarioDesc();

        return ResponseEntity.ok().body(funcionario);
    }

    // Lista os 3 primeiros funcionário que possuem o maior salário
    @RequestMapping(value="/tressaldesc")
    public ResponseEntity<List<Funcionario>> findFirst3ByOrderBySalFuncionarioDesc() {

        List<Funcionario> funcionario = funcService.findFirst3ByOrderBySalFuncionarioDesc();

        return ResponseEntity.ok().body(funcionario);
    }

    // Lista os funcionário sem dependentes
    @RequestMapping(value="/withoutdep")
    public ResponseEntity<List<Funcionario>> findFuncionarioWithoutDependente() {

        List<Funcionario> funcionario = funcService.findFuncionarioWithoutDependente();

        return ResponseEntity.ok().body(funcionario);
    }

    // Listar os funcionários que tem salário maior que um determinado valor por JPQL
    // sobrescrevendo palavras-chaves @Query.
    @RequestMapping(value="/bysalario/{valSalario}")
    public ResponseEntity<List<Funcionario>> listFuncionarioBySalario(@PathVariable Float valSalario) {

        List<Funcionario> funcionario = funcService.listFuncionarioBySalario(valSalario);

        return ResponseEntity.ok().body(funcionario);
    }

    // Listar os funcionários que tem salário maior que um determinado valor por @Query
    // com native query
    @RequestMapping(value="/bysalarioNat/{valSalario}")
    public ResponseEntity<List<Funcionario>> listFuncionarioBySalarioNativeQuery(@PathVariable Float valSalario) {

        List<Funcionario> funcionario = funcService.listFuncionarioBySalarioNativeQuery(valSalario);

        return ResponseEntity.ok().body(funcionario);
    }

    // Lista os funcionários com uma determinada quantidade de dependentes por @NamedQuery.
    @RequestMapping(value="/qtdeDep/{qtdeDep}")
    public ResponseEntity<List<Funcionario>> listFuncionarioByQtdeDep(@PathVariable Integer qtdeDep) {

        List<Funcionario> funcionario = funcService.listFuncionarioByQtdeDep(qtdeDep);

        return ResponseEntity.ok().body(funcionario);
    }

    // Lista os funcionários que contenham em qualquer parte do seu nome um determinado nome por
    // @NamedNativeQuery

    @RequestMapping(value="/partenome")
    public ResponseEntity<List<Funcionario>> listByParteNome(@RequestParam(name="nome") String nome) {

        List<Funcionario> funcionario = funcService.listByParteNome(nome);

        return ResponseEntity.ok().body(funcionario);
    }

    @PutMapping(value = "/updateSalario/{percAumento}")
    public ResponseEntity<Void> funcUpdateSalario(@PathVariable Integer percAumento) {

        funcService.procedureUpdateSalario(percAumento);
        return ResponseEntity.noContent().build();
    }

    // Instrução com anotação @Modifing e instrução update que troca todos os funcionários de um determinado
    // departamento para outro departamento utilizando a anotação @Modifying.
    @PutMapping(value = "/updateFuncByDepto/{oldDepart_id},{newDepart_id}")
    public ResponseEntity<Void> funcUpdateByDepartamento(@PathVariable Long oldDepart_id, @PathVariable Long newDepart_id) {

        funcService.updateFuncionarioByDepartamento(oldDepart_id, newDepart_id);
        return ResponseEntity.noContent().build();
    }

    // Instrução com anotação @Modifing e instrução delete que exclui todos os funcionários de um determinado
    // departamento utilizando a anotação @Modifying.
    @PutMapping(value = "/deleteFuncByDepto/{departamento_id}")
    public ResponseEntity<Void> deleteFuncionarioByDepartamento(@PathVariable Long departamento_id) {

        funcService.deleteFuncionarioByDepartamento(departamento_id);
        return ResponseEntity.noContent().build();
    }
}

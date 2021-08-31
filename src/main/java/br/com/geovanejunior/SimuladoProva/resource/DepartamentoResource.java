package br.com.geovanejunior.SimuladoProva.resource;

import br.com.geovanejunior.SimuladoProva.entity.Departamento;
import br.com.geovanejunior.SimuladoProva.service.DepartamentoService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/departamento")
public class DepartamentoResource {

    @Autowired
    private DepartamentoService deptoService;

    @GetMapping
    public ResponseEntity<List<Departamento>> findAll() {

        List<Departamento> list = deptoService.findAll();

        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/first")
    public ResponseEntity<Departamento> findFirstBy() {

        Departamento depto = deptoService.findFirstBy();

        return ResponseEntity.ok().body(depto);

    }
    @PostMapping(value = "/insertNewDepartamento")
//    public ResponseEntity<Departamento> insertNewDepartamento(@RequestBody String nomeDepto, Long idFuncionario) {
    public ResponseEntity<Departamento> insertNewDepartamento(@RequestBody ObjectNode newDepto) {

        String nomeDepto = newDepto.get("nomeDepto").asText();
        Long idFuncionario = newDepto.get("idFuncionario").asLong();

        Departamento depto = new Departamento(nomeDepto);
        depto = deptoService.insertNewDepartamento(depto, idFuncionario);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(depto).toUri();

        return ResponseEntity.created(uri).body(depto);
    }
}

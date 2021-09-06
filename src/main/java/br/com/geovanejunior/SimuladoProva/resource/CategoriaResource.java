package br.com.geovanejunior.SimuladoProva.resource;

import br.com.geovanejunior.SimuladoProva.entity.Categoria;
import br.com.geovanejunior.SimuladoProva.entity.Departamento;
import br.com.geovanejunior.SimuladoProva.service.CategoriaService;
import br.com.geovanejunior.SimuladoProva.service.DepartamentoService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaServ;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll() {

        List<Categoria> list = categoriaServ.findAll();

        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{codCategoria}")
    public ResponseEntity<Categoria> findById(@PathVariable Long codCategoria) {

        Categoria categ = categoriaServ.findById(codCategoria);

        return ResponseEntity.ok().body(categ);

    }

    @PutMapping(value = "/delete/{codCategoria}")
    public ResponseEntity<Void> deleteById(@PathVariable Long codCategoria) {

        categoriaServ.deleteById(codCategoria);
        return ResponseEntity.noContent().build();
    }
//    @PostMapping(value = "/insertNewDepartamento")
////    public ResponseEntity<Departamento> insertNewDepartamento(@RequestBody String nomeDepto, Long idFuncionario) {
//    public ResponseEntity<Departamento> insertNewDepartamento(@RequestBody ObjectNode newDepto) {
//
//        String nomeDepto = newDepto.get("nomeDepto").asText();
//        Long idFuncionario = newDepto.get("idFuncionario").asLong();
//
//        Departamento depto = new Departamento(nomeDepto);
//        depto = deptoService.insertNewDepartamento(depto, idFuncionario);
//
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(depto).toUri();
//
//        return ResponseEntity.created(uri).body(depto);
//    }
}

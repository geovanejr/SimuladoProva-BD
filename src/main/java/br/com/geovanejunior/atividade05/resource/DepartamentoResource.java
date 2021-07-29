package br.com.geovanejunior.atividade05.resource;

import br.com.geovanejunior.atividade05.entity.Departamento;
import br.com.geovanejunior.atividade05.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

}

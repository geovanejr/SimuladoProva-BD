package br.com.geovanejunior.SimuladoProva.resource;

import br.com.geovanejunior.SimuladoProva.entity.Pessoa;
import br.com.geovanejunior.SimuladoProva.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaServ;

    @RequestMapping
    public ResponseEntity<List<Pessoa>> findAll() {

        List<Pessoa> pessoa = pessoaServ.findAll();

        System.out.println("Teste Lista Pessoas");
        return ResponseEntity.ok().body(pessoa);
    }

    @GetMapping(value="/{idPessoa}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long idPessoa) {

        Pessoa pessoa = pessoaServ.findById(idPessoa);

        System.out.println("Teste Lista Pessoas");
        return ResponseEntity.ok().body(pessoa);
    }
}

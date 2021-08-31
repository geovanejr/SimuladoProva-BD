package br.com.geovanejunior.SimuladoProva.resource;

import br.com.geovanejunior.SimuladoProva.entity.Gravacao;
import br.com.geovanejunior.SimuladoProva.entity.Pessoa;
import br.com.geovanejunior.SimuladoProva.repository.GravacaoRepository;
import br.com.geovanejunior.SimuladoProva.service.GravacaoService;
import br.com.geovanejunior.SimuladoProva.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gravacao")
public class GravacaoResource {

    @Autowired
    private GravacaoService gravacaoServ;

    @Autowired
    private GravacaoRepository gravacaoRepo;

    @RequestMapping
    public ResponseEntity<List<Gravacao>> findAll() {

        List<Gravacao> gravacao = gravacaoServ.findAll();

        System.out.println("Teste Lista Gravacao");
        return ResponseEntity.ok().body(gravacao);
    }

    @GetMapping(value="/{idGravacao}")
    public ResponseEntity<Gravacao> findById(@PathVariable Long idGravacao) {

        Gravacao gravacao = gravacaoServ.findById(idGravacao);

        System.out.println("Teste Consulta Gravação");
        return ResponseEntity.ok().body(gravacao);
    }

    @GetMapping(value="/page")
    public ResponseEntity<Page<Gravacao>> pageGravacao(Pageable pageable) {

        Page<Gravacao> gravacaoPage = gravacaoRepo.findAll(pageable);

        return ResponseEntity.ok().body(gravacaoPage);
    }

    @GetMapping(value="/pageOrder")
    public ResponseEntity<Page<Gravacao>> pageGravacaoOrder(@RequestParam(value="page", defaultValue = "0") Integer page,
                                                            @RequestParam(value = "linesOfPage", defaultValue = "24") Integer linesOfPage) {

        Page<Gravacao> gravacaoPage = gravacaoServ.pageGravacaoOrder(page, linesOfPage);

        return ResponseEntity.ok().body(gravacaoPage);
    }
}

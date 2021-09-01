package br.com.geovanejunior.SimuladoProva.service;

import br.com.geovanejunior.SimuladoProva.entity.Cantor;
import br.com.geovanejunior.SimuladoProva.entity.Gravacao;
import br.com.geovanejunior.SimuladoProva.entity.Gravadora;
import br.com.geovanejunior.SimuladoProva.entity.Musica;
import br.com.geovanejunior.SimuladoProva.repository.GravacaoRepository;
import br.com.geovanejunior.SimuladoProva.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GravacaoService {

    @Autowired
    private GravacaoRepository gravacaoRepo;

    @Autowired
    private CantorService cantorServ;

    @Autowired
    private GravadoraService gravadoraServ;

    @Autowired
    private MusicaService musicaServ;

    public List<Gravacao> findAll() {

        return gravacaoRepo.findAll();
    }

    public Gravacao findById(Long codGravacao) {

        Optional<Gravacao> gravacao = gravacaoRepo.findById(codGravacao);
        return gravacao.orElseThrow(() -> new ObjectNotFoundException(
                "Gravação não encontrada. Id: " + codGravacao + ", Tipo: " + Gravacao.class.getName()
        ));
    }

    public List<Gravacao> findByCantor(Long codCantor) {

        Cantor cantor = cantorServ.findById(codCantor);

        return gravacaoRepo.findGravacaoByCantor(cantor);
    }

    @Transactional(readOnly = false)
    public void save(LocalDate dtGravacao, Long codGravadora, Long codCantor, Long codMusica) {

        Gravadora gravadora = gravadoraServ.findById(codGravadora);
        Cantor cantor = cantorServ.findById(codCantor);
        Musica musica = musicaServ.findById(codMusica);

        Gravacao gravacao = new Gravacao(dtGravacao, gravadora, cantor, musica);
        gravacaoRepo.save(gravacao);
    }

    public Page<Gravacao> pageGravacaoOrder(Integer page, Integer size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        return gravacaoRepo.findAll(pageRequest);
    }
}

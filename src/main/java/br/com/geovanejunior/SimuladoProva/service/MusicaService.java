package br.com.geovanejunior.SimuladoProva.service;

import br.com.geovanejunior.SimuladoProva.entity.Categoria;
import br.com.geovanejunior.SimuladoProva.entity.Musica;
import br.com.geovanejunior.SimuladoProva.repository.MusicaRepository;
import br.com.geovanejunior.SimuladoProva.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepo;

    @Autowired
    private CategoriaService categoriaServ;

    public List<Musica> findAll() {

        return musicaRepo.findAll();
    }

    public Musica findById(Long codMusica) {

        Optional<Musica> musica = musicaRepo.findById(codMusica);

        return musica.orElseThrow(() -> new ObjectNotFoundException(
                "Música não encontrada. Id: " + codMusica + ", Tipo: " + Musica.class.getName()
        ));
    }

//    @Transactional(readOnly = true)
//    public void save(Musica musica, Long codCategoria) {
//
//        var categ = categoriaServ.findById(codCategoria);
//        musica.setCategoria(categ);
//        musicaRepo.save(musica);
//    }

//    @Transactional(readOnly = true)
//    public void save(Musica musica) {
//        musicaRepo.save(musica);
//    }
//
    @Transactional(readOnly = true)
    public void saveMusica(Integer duracao, String titulo, Long codCategoria) {

        var categ = categoriaServ.findById(codCategoria);
        var musica = new Musica(duracao, titulo, categ);
        musicaRepo.save(musica);
    }

}

package br.com.geovanejunior.SimuladoProva.service;

import br.com.geovanejunior.SimuladoProva.entity.Gravadora;
import br.com.geovanejunior.SimuladoProva.repository.GravadoraRepository;
import br.com.geovanejunior.SimuladoProva.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GravadoraService {

    @Autowired
    private GravadoraRepository gravadoraRepo;

    public List<Gravadora> findAll() {

        return gravadoraRepo.findAll();
    }

    public Gravadora findById(Long codGravadora) {

        Optional<Gravadora> gravadora = gravadoraRepo.findById(codGravadora);

        return gravadora.orElseThrow(() -> new ObjectNotFoundException(
                "Gravadora não encontrada. Id: " + codGravadora + ", Tipo: " + Gravadora.class.getName()
        ));
    }
    @Transactional(readOnly = false)
    public void save(Gravadora gravadora) {

        gravadoraRepo.save(gravadora);
    }
}

package br.com.geovanejunior.SimuladoProva.service;

import br.com.geovanejunior.SimuladoProva.entity.Cantor;
import br.com.geovanejunior.SimuladoProva.repository.CantorRepository;
import br.com.geovanejunior.SimuladoProva.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CantorService {

    @Autowired
    private CantorRepository cantorRepo;

    public List<Cantor> findAll() {

        return cantorRepo.findAll();
    }

    public Cantor findById(Long codCantor) {

        Optional<Cantor> cantor = cantorRepo.findById(codCantor);

        return cantor.orElseThrow(() -> new ObjectNotFoundException(
                "Cantor não encontrado. Id: " + codCantor + ", Tipo: " + Cantor.class.getName()
        ));
    }

    @Transactional(readOnly = false)
    public void save(Cantor cantor) {

        cantorRepo.save(cantor);
    }
}

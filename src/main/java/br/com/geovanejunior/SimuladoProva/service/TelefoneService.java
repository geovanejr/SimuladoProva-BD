package br.com.geovanejunior.SimuladoProva.service;

import br.com.geovanejunior.SimuladoProva.entity.Pessoa;
import br.com.geovanejunior.SimuladoProva.entity.Telefone;
import br.com.geovanejunior.SimuladoProva.repository.PessoaRepository;
import br.com.geovanejunior.SimuladoProva.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefRepo;

    public List<Telefone> findAll() {

        return telefRepo.findAll();
    }

    @Transactional(readOnly = true)
    public void save(Telefone telefone) {

        telefRepo.save(telefone);
    }
}

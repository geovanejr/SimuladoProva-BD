package br.com.geovanejunior.atividade05.service;

import br.com.geovanejunior.atividade05.entity.Departamento;
import br.com.geovanejunior.atividade05.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository depRepo;

    public List<Departamento> findAll() {

        return depRepo.findAll();
    }

    public Optional<Departamento> findById(Long id) {

        return depRepo.findById(id);
    }

    public void save(Departamento depto) {

        depRepo.save(depto);
    }
}

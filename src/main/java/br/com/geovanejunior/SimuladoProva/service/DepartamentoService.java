package br.com.geovanejunior.SimuladoProva.service;

import br.com.geovanejunior.SimuladoProva.entity.Departamento;
import br.com.geovanejunior.SimuladoProva.repository.DepartamentoRepository;
import br.com.geovanejunior.SimuladoProva.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository depRepo;

    @Autowired
    private FuncionarioRepository funcRepo;

    @Autowired
    private FuncionarioService funcService;

    public List<Departamento> findAll() {

        return depRepo.findAll();
    }

    public Optional<Departamento> findById(Long id) {

        return depRepo.findById(id);
    }

    public void save(Departamento depto) {

        depRepo.save(depto);
    }

    // Listar o primeiro departamento cadastrado.
    public Departamento findFirstBy() {

        return depRepo.findFirstBy();
    }

    // Método para salvar um departamento, associar esse departamento a um funcionário e
    // salvar esse funcionário em um mesmo controle de transação.
    @Transactional(readOnly = false)
    public Departamento insertNewDepartamento(Departamento departamento, Long idFuncionario) {

        var func = funcService.findById(idFuncionario);
        depRepo.save(departamento);
        func.setDepartamento(departamento);
        funcRepo.save(func);

        return departamento;
    }
}

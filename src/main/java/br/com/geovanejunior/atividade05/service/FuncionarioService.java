package br.com.geovanejunior.atividade05.service;

import br.com.geovanejunior.atividade05.entity.Funcionario;
import br.com.geovanejunior.atividade05.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repFunc;

    public List<Funcionario> findAll() {

        return repFunc.findAll();
    }

    public Optional<Funcionario> findById(Long id) {

        return repFunc.findById(id);
    }

    public void save(Funcionario funcionario) {

        repFunc.save(funcionario);
    }
}

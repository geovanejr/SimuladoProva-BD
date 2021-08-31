package br.com.geovanejunior.SimuladoProva.service;

import br.com.geovanejunior.SimuladoProva.entity.Pessoa;
import br.com.geovanejunior.SimuladoProva.repository.PessoaRepository;
import br.com.geovanejunior.SimuladoProva.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepo;

    public List<Pessoa> findAll() {

        return pessoaRepo.findAll();
    }

    public Pessoa findById(Long codPessoa) {

        Optional<Pessoa> pessoa = pessoaRepo.findById(codPessoa);

        return pessoa.orElseThrow(() -> new ObjectNotFoundException(
                "Pessoa não encontrada. Id " + codPessoa + "Tipo:" + Pessoa.class.getName()));
    }

    @Transactional(readOnly = false)
    public void save(Pessoa pessoa) {

        pessoaRepo.save(pessoa);
    }
}

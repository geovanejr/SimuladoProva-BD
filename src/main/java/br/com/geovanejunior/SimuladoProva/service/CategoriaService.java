package br.com.geovanejunior.SimuladoProva.service;

import br.com.geovanejunior.SimuladoProva.entity.Categoria;
import br.com.geovanejunior.SimuladoProva.repository.CategoriaRepository;
import br.com.geovanejunior.SimuladoProva.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categRepo;

    public List<Categoria> findAll() {

        return categRepo.findAll();
    }

    public Categoria findById(Long codCategoria) {

        Optional<Categoria> categoria = categRepo.findById(codCategoria);

        return categoria.orElseThrow(() -> new ObjectNotFoundException(
                "Funcionario não encontrado. Id: " + codCategoria + ", Tipo: " + Categoria.class.getName()));
    }

    @Transactional(readOnly = false)
    public void save(Categoria categoria) {

        categRepo.save(categoria);
    }
}

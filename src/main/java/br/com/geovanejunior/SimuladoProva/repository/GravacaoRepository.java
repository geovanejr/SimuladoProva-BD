package br.com.geovanejunior.SimuladoProva.repository;

import br.com.geovanejunior.SimuladoProva.entity.Cantor;
import br.com.geovanejunior.SimuladoProva.entity.Gravacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GravacaoRepository extends JpaRepository<Gravacao, Long> {

    List<Gravacao> findGravacaoByCantor(Cantor cantor);
}

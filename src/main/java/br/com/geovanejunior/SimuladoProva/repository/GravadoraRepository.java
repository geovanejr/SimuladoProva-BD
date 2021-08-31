package br.com.geovanejunior.SimuladoProva.repository;

import br.com.geovanejunior.SimuladoProva.entity.Gravadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GravadoraRepository extends JpaRepository<Gravadora, Long> {
}

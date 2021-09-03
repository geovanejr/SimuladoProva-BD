package br.com.geovanejunior.SimuladoProva.repository;

import br.com.geovanejunior.SimuladoProva.entity.Cantor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CantorRepository extends JpaRepository<Cantor, Long> {

    @Query(name = "Cantor.byPartName")
    List<Cantor> findByPartName(@Param("keyword") String nome);
}

package br.com.geovanejunior.SimuladoProva.repository;

import br.com.geovanejunior.SimuladoProva.entity.Cantor;
import br.com.geovanejunior.SimuladoProva.entity.Gravacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GravacaoRepository extends JpaRepository<Gravacao, Long> {

    List<Gravacao> findGravacaoByCantor(Cantor cantor);

    @Query("Select obj from Gravacao obj JOIN FETCH obj.musica WHERE obj.cantor in :cantor")
    List<Gravacao> findGravacaoByCantor(List<Cantor> cantor);

//    @Query("Select grav from Gravacao grav where  grav.dataGravacao = :anoGravacao")
    @Query(value = "Select * from tb_gravacao where YEAR(data_gravacao) = :anoGravacao", nativeQuery = true)
    List<Gravacao> findByAnoDataGravacao(@Param("anoGravacao") Integer anoGravacao);
}

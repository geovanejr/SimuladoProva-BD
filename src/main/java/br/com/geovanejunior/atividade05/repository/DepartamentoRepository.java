package br.com.geovanejunior.atividade05.repository;

import br.com.geovanejunior.atividade05.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}

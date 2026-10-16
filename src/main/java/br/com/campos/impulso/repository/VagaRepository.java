package br.com.campos.impulso.repository;

import br.com.campos.impulso.entity.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VagaRepository extends JpaRepository<Vaga, Long> {
    boolean existsByEmpresaId(Long empresaId);
}

package br.com.campos.impulso.repository;

import br.com.campos.impulso.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    boolean existsByEmpresaId(Long empresaId);
}

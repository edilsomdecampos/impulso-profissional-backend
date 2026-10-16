package br.com.campos.impulso.service;

import br.com.campos.impulso.dto.CursoRequest;
import br.com.campos.impulso.entity.Curso;
import br.com.campos.impulso.entity.Empresa;
import br.com.campos.impulso.exception.RecursoNaoEncontradoException;
import br.com.campos.impulso.repository.CursoRepository;
import br.com.campos.impulso.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;
    private final EmpresaRepository empresaRepository;

    public CursoService(CursoRepository cursoRepository, EmpresaRepository empresaRepository) {
        this.cursoRepository = cursoRepository;
        this.empresaRepository = empresaRepository;
    }

    public List<Curso> listar() { return cursoRepository.findAll(); }

    public Curso buscar(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Curso não encontrado."));
    }

    public Curso criar(CursoRequest request) {
        Curso curso = new Curso();
        preencher(curso, request);
        return cursoRepository.save(curso);
    }

    public Curso atualizar(Long id, CursoRequest request) {
        Curso curso = buscar(id);
        preencher(curso, request);
        return cursoRepository.save(curso);
    }

    public void excluir(Long id) {
        buscar(id);
        cursoRepository.deleteById(id);
    }

    private void preencher(Curso curso, CursoRequest request) {
        Empresa empresa = empresaRepository.findById(request.empresaId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Empresa informada não encontrada."));
        curso.setTitulo(request.titulo());
        curso.setDescricao(request.descricao());
        curso.setCargaHoraria(request.cargaHoraria());
        curso.setFormato(request.formato());
        curso.setEmpresa(empresa);
    }
}

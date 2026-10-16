package br.com.campos.impulso.service;

import br.com.campos.impulso.dto.VagaRequest;
import br.com.campos.impulso.entity.Empresa;
import br.com.campos.impulso.entity.Vaga;
import br.com.campos.impulso.exception.RecursoNaoEncontradoException;
import br.com.campos.impulso.repository.EmpresaRepository;
import br.com.campos.impulso.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {
    private final VagaRepository vagaRepository;
    private final EmpresaRepository empresaRepository;

    public VagaService(VagaRepository vagaRepository, EmpresaRepository empresaRepository) {
        this.vagaRepository = vagaRepository;
        this.empresaRepository = empresaRepository;
    }

    public List<Vaga> listar() { return vagaRepository.findAll(); }

    public Vaga buscar(Long id) {
        return vagaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Vaga não encontrada."));
    }

    public Vaga criar(VagaRequest request) {
        Vaga vaga = new Vaga();
        preencher(vaga, request);
        return vagaRepository.save(vaga);
    }

    public Vaga atualizar(Long id, VagaRequest request) {
        Vaga vaga = buscar(id);
        preencher(vaga, request);
        return vagaRepository.save(vaga);
    }

    public void excluir(Long id) {
        buscar(id);
        vagaRepository.deleteById(id);
    }

    private void preencher(Vaga vaga, VagaRequest request) {
        Empresa empresa = empresaRepository.findById(request.empresaId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Empresa informada não encontrada."));
        vaga.setTitulo(request.titulo());
        vaga.setDescricao(request.descricao());
        vaga.setModalidade(request.modalidade());
        vaga.setNivel(request.nivel());
        vaga.setDataLimite(request.dataLimite());
        vaga.setEmpresa(empresa);
    }
}

package br.com.campos.impulso.service;

import br.com.campos.impulso.entity.Empresa;
import br.com.campos.impulso.exception.RecursoNaoEncontradoException;
import br.com.campos.impulso.exception.RegraNegocioException;
import br.com.campos.impulso.repository.CursoRepository;
import br.com.campos.impulso.repository.EmpresaRepository;
import br.com.campos.impulso.repository.VagaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final VagaRepository vagaRepository;
    private final CursoRepository cursoRepository;

    public EmpresaService(
            EmpresaRepository empresaRepository,
            VagaRepository vagaRepository,
            CursoRepository cursoRepository) {

        this.empresaRepository = empresaRepository;
        this.vagaRepository = vagaRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<Empresa> listar() {
        return empresaRepository.findAll();
    }

    public Empresa buscar(Long id) {
        return empresaRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Empresa não encontrada com o id: " + id
                        )
                );
    }

    public Empresa criar(Empresa empresa) {
        empresa.setId(null);
        return empresaRepository.save(empresa);
    }

    public Empresa atualizar(Long id, Empresa empresaAtualizada) {

        Empresa empresa = buscar(id);

        empresa.setNome(empresaAtualizada.getNome());
        empresa.setCnpj(empresaAtualizada.getCnpj());
        empresa.setEmail(empresaAtualizada.getEmail());
        empresa.setCidade(empresaAtualizada.getCidade());

        return empresaRepository.save(empresa);
    }

    public void excluir(Long id) {

        Empresa empresa = buscar(id);

        boolean possuiVagas =
                vagaRepository.existsByEmpresaId(id);

        boolean possuiCursos =
                cursoRepository.existsByEmpresaId(id);

        if (possuiVagas || possuiCursos) {
            throw new RegraNegocioException(
                    "Não é possível excluir uma empresa que possui vagas ou cursos vinculados."
            );
        }

        empresaRepository.delete(empresa);
    }
}
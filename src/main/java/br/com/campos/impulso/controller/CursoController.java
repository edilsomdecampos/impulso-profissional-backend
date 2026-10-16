package br.com.campos.impulso.controller;

import br.com.campos.impulso.dto.CursoRequest;
import br.com.campos.impulso.entity.Curso;
import br.com.campos.impulso.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "http://localhost:5173")
public class CursoController {
    private final CursoService service;

    public CursoController(CursoService service) { this.service = service; }

    @GetMapping
    public List<Curso> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Curso buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    public ResponseEntity<Curso> criar(@Valid @RequestBody CursoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @PutMapping("/{id}")
    public Curso atualizar(@PathVariable Long id, @Valid @RequestBody CursoRequest request) {
        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

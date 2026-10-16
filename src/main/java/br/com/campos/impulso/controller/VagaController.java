package br.com.campos.impulso.controller;

import br.com.campos.impulso.dto.VagaRequest;
import br.com.campos.impulso.entity.Vaga;
import br.com.campos.impulso.service.VagaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vagas")
@CrossOrigin(origins = "http://localhost:5173")
public class VagaController {
    private final VagaService service;

    public VagaController(VagaService service) { this.service = service; }

    @GetMapping
    public List<Vaga> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Vaga buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    public ResponseEntity<Vaga> criar(@Valid @RequestBody VagaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(request));
    }

    @PutMapping("/{id}")
    public Vaga atualizar(@PathVariable Long id, @Valid @RequestBody VagaRequest request) {
        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

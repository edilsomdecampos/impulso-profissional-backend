package br.com.campos.impulso.controller;

import br.com.campos.impulso.entity.Empresa;
import br.com.campos.impulso.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "http://localhost:5173")
public class EmpresaController {
    private final EmpresaService service;

    public EmpresaController(EmpresaService service) { this.service = service; }

    @GetMapping
    public List<Empresa> listar() { return service.listar(); }

    @GetMapping("/{id}")
    public Empresa buscar(@PathVariable Long id) { return service.buscar(id); }

    @PostMapping
    public ResponseEntity<Empresa> criar(@Valid @RequestBody Empresa empresa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(empresa));
    }

    @PutMapping("/{id}")
    public Empresa atualizar(@PathVariable Long id, @Valid @RequestBody Empresa empresa) {
        return service.atualizar(id, empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

package br.com.campos.impulso.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record VagaRequest(
        @NotBlank String titulo,
        @NotBlank String descricao,
        @NotBlank String modalidade,
        @NotBlank String nivel,
        @NotNull LocalDate dataLimite,
        @NotNull Long empresaId
) {}

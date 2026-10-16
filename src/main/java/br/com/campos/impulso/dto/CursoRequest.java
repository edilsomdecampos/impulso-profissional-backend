package br.com.campos.impulso.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoRequest(
        @NotBlank String titulo,
        @NotBlank String descricao,
        @NotNull Integer cargaHoraria,
        @NotBlank String formato,
        @NotNull Long empresaId
) {}

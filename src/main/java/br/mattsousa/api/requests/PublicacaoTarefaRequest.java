package br.mattsousa.api.requests;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record PublicacaoTarefaRequest (
    @NotNull(message = "Recompensa é obrigatório")
    @Min(value = 1, message = "Recompensa deve ser maior que 0")
    BigDecimal recompensa
) {}

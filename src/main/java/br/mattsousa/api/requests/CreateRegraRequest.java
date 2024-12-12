package br.mattsousa.api.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public record CreateRegraRequest (
    @NotBlank(message = "Campo obrigatório") 
    @Max(value = 128, message = "Limite de 128 caracteres") String nome
){}

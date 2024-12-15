package br.mattsousa.api.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateRegraRequest (
    @NotBlank(message = "Campo obrigatório") 
    @Size(max = 128, message = "Limite de 128 caracteres") String nome
){}

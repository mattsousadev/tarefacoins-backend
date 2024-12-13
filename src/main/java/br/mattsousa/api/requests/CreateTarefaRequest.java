package br.mattsousa.api.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTarefaRequest(
    @NotBlank(message = "Campo 'nome' é obrigatório") 
    @Size(max = 128, message = "Limite do campo 'nome': 128")
    String nome,

    @NotBlank(message = "Campo 'descricao' é obrigatório") 
    @Size(max = 256, message = "Limite do campo 'descricao': 256")
    String descricao,
    
    Boolean ativo
) {
    public CreateTarefaRequest {
        if (ativo == null) {
            ativo = true;
        }
    }
}

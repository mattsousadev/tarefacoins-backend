package br.mattsousa.api.requests;

import jakarta.validation.constraints.NotBlank;

public record CreateUsersRequest(
    @NotBlank String name
    , @NotBlank String email
    , @NotBlank String birthDate
    , Boolean isActive
) {}

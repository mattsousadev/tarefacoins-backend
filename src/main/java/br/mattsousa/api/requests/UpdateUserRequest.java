package br.mattsousa.api.requests;

public record UpdateUserRequest(
    String name
    , String email
    , String birthDate
    , Boolean isActive
) {} 

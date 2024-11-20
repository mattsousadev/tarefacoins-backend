package br.mattsousa.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mattsousa.data.models.UsersModel;

public interface UsersRepository extends JpaRepository<UsersModel, String> {

    Optional<UsersModel> findByEmail(String email);}

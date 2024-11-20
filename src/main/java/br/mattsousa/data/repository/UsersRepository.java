package br.mattsousa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mattsousa.data.models.UsersModel;

public interface UsersRepository extends JpaRepository<UsersModel, String> {}

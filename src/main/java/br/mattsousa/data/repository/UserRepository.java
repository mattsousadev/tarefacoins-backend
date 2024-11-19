package br.mattsousa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mattsousa.data.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {}

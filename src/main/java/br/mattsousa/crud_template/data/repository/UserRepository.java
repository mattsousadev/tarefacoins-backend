package br.mattsousa.crud_template.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.mattsousa.crud_template.data.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {}

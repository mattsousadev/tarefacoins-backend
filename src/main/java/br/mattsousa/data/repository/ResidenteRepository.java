package br.mattsousa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mattsousa.data.models.ResidenteModel;

@Repository
public interface ResidenteRepository extends JpaRepository<ResidenteModel, String>{ }

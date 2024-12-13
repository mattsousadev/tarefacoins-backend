package br.mattsousa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mattsousa.data.models.TarefasPublicadasModel;

@Repository
public interface TarefasPublicadasRepository extends JpaRepository <TarefasPublicadasModel, Integer> {}

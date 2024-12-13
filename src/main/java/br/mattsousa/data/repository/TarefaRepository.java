package br.mattsousa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mattsousa.data.models.TarefaModel;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, String> {  
    
}

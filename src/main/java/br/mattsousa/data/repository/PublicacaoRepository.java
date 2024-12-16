package br.mattsousa.data.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.mattsousa.data.models.PublicacaoModel;
import br.mattsousa.data.models.TarefaModel;

@Repository
public interface PublicacaoRepository extends JpaRepository <PublicacaoModel, String>{

    @Query("SELECT p.id FROM PublicacaoModel p WHERE p.tarefa = :tarefa")
    Set<String> findIdsByTarefa(@Param(value = "tarefa") TarefaModel tarefa);
    
}

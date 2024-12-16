package br.mattsousa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.mattsousa.data.models.RegraModel;

@Repository
public interface RegraRepository extends JpaRepository<RegraModel, String> {

    @Query("SELECT COUNT(rm) > 0 FROM RegraModel rm JOIN rm.aplicacoesRegra WHERE rm.id = :id")
    boolean isApplied(@Param(value = "id") String id);
    
}

package br.mattsousa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mattsousa.data.models.PublicacaoModel;

@Repository
public interface PublicacaoRepository extends JpaRepository <PublicacaoModel, String>{
    
}

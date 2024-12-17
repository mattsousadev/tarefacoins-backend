package br.mattsousa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mattsousa.data.models.RegraAplicadaModel;

@Repository
public interface RegraAplicadaRepository extends JpaRepository<RegraAplicadaModel, String> {

    void deleteAllByIdPublicacao(String idPublicacao);
    
}

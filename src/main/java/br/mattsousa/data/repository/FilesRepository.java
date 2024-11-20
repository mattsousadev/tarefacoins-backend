package br.mattsousa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.mattsousa.data.models.FilesModel;

@Repository
public interface FilesRepository extends JpaRepository<FilesModel, String> { }

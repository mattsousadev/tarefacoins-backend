package br.mattsousa.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.mattsousa.data.models.TarefasPublicadasModel;
import br.mattsousa.data.repository.TarefasPublicadasRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefasPublicadasRepository tarefasPublicadasRepository;

    public List<TarefasPublicadasModel> listPublished() {
        Sort sort = Sort.by(Direction.DESC, "dataCriacaoTarefa");
        return tarefasPublicadasRepository.findAll(sort);
    }
    
}

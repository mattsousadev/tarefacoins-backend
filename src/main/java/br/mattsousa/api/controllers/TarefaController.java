package br.mattsousa.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.data.models.TarefasPublicadasModel;
import br.mattsousa.domain.services.TarefaService;

@Service
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    public List<TarefasPublicadasModel> listPublished() {
        return tarefaService.listPublished();
    }
    
}

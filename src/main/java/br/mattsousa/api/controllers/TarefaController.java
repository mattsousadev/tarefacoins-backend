package br.mattsousa.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.api.requests.CreateTarefaRequest;
import br.mattsousa.api.requests.PublicacaoTarefaRequest;
import br.mattsousa.api.requests.UpdateTarefaRequest;
import br.mattsousa.data.models.PublicacaoModel;
import br.mattsousa.data.models.TarefaModel;
import br.mattsousa.data.models.TarefasPublicadasModel;
import br.mattsousa.domain.exceptions.TarefaNotFoundException;
import br.mattsousa.domain.services.TarefaService;
import jakarta.transaction.Transactional;

@Service
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    public List<TarefaModel> list() {
        return tarefaService.listTarefas();
    }

    public List<TarefasPublicadasModel> listPublished() {
        return tarefaService.listPublished();
    }

    public String create(CreateTarefaRequest request) {
        TarefaModel newTarefa = new TarefaModel();
        newTarefa.setNome(request.nome());
        newTarefa.setDescricao(request.descricao());
        newTarefa.setAtivo(request.ativo());
        newTarefa = tarefaService.createTarefa(newTarefa);
        return newTarefa.getId();
    }

    public TarefaModel getTarefa(String id) {
        if (!tarefaService.checkTarefaExists(id)) {
            throw new TarefaNotFoundException("Tarefa não encontrada");
        }
        return tarefaService.getTarefa(id);
    }

    public TarefasPublicadasModel getPublishedTarefa(String id) {
        if (!tarefaService.checkTarefaExists(id)) {
            throw new TarefaNotFoundException("Tarefa não encontrada");
        }

        if (!tarefaService.checkTarefaPublicada(id)) {
            throw new TarefaNotFoundException("Tarefa não publicada");
        }
        return tarefaService.getPublishedTarefa(id);
    }

    public void publish(String id, PublicacaoTarefaRequest request) {
        TarefaModel tarefa = getTarefa(id);
        PublicacaoModel newPublicacaoModel = new PublicacaoModel();
        newPublicacaoModel.setTarefa(tarefa);
        newPublicacaoModel.setRecompensa(request.recompensa());
        tarefaService.createPublicacao(newPublicacaoModel);
    }

    @Transactional
    public void delete(String id) {
        if (!tarefaService.checkTarefaExists(id)) {
            throw new TarefaNotFoundException("Tarefa não encontrada");
        }
        tarefaService.deleteTarefa(id);
    }

    public void update(String id, UpdateTarefaRequest request) {
        if (!tarefaService.checkTarefaExists(id)) {
            throw new TarefaNotFoundException("Tarefa não encontrada");
        }

        tarefaService.updateTarefa(id, request);
    }
    
}

package br.mattsousa.domain.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.mattsousa.api.requests.UpdateTarefaRequest;
import br.mattsousa.data.models.PublicacaoModel;
import br.mattsousa.data.models.TarefaModel;
import br.mattsousa.data.models.TarefasPublicadasModel;
import br.mattsousa.data.repository.PublicacaoRepository;
import br.mattsousa.data.repository.TarefaRepository;
import br.mattsousa.data.repository.TarefasPublicadasRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Autowired
    private TarefasPublicadasRepository tarefasPublicadasRepository;

    public List<TarefaModel> listTarefas() {
        return tarefaRepository.findAll();
    }

    public List<TarefasPublicadasModel> listPublished() {
        Sort sort = Sort.by(Direction.DESC, "dataCriacaoTarefa");
        return tarefasPublicadasRepository.findAll(sort);
    }

    public TarefaModel createTarefa(TarefaModel newTarefa) {
        return tarefaRepository.save(newTarefa);
    }

    public boolean checkTarefaExists(String id) {
        return tarefaRepository.existsById(id);
    }

    public TarefaModel getTarefa(String id) {
        return tarefaRepository.findById(id).get();
    }

    public TarefasPublicadasModel getPublishedTarefa(String id) {
        return tarefasPublicadasRepository.findOneByIdTarefa(id);
    }

    public boolean checkTarefaPublicada(String id) {
        return tarefasPublicadasRepository.existsByIdTarefa(id);
    }

    public PublicacaoModel createPublicacao(PublicacaoModel newPublicacaoModel) {
        return publicacaoRepository.save(newPublicacaoModel);
    }

    public void deleteTarefa(String id) {
        TarefaModel tarefaModel = getTarefa(id);

        Set<String> publicacoes = publicacaoRepository.findIdsByTarefa(tarefaModel);
        
        if(!publicacoes.isEmpty()) {
            publicacaoRepository.deleteAllById(publicacoes);
        }
        
        tarefaRepository.delete(tarefaModel);
    }

    public void updateTarefa(String id, UpdateTarefaRequest request) {
        TarefaModel tarefaModel = getTarefa(id);

        tarefaModel.setNome(request.nome());
        tarefaModel.setDescricao(request.descricao());
        tarefaModel.setAtivo(request.ativo());

        tarefaRepository.save(tarefaModel);

    }
    
}

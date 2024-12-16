package br.mattsousa.api.routes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mattsousa.api.controllers.TarefaController;
import br.mattsousa.api.requests.CreateTarefaRequest;
import br.mattsousa.api.requests.PublicacaoTarefaRequest;
import br.mattsousa.data.models.TarefaModel;
import br.mattsousa.data.models.TarefasPublicadasModel;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tarefas")
public class TarefaRoute {

    @Autowired
    private TarefaController tarefaController;

    @GetMapping
    public ResponseEntity<List<TarefaModel>> list() {
        return ResponseEntity.ok().body(tarefaController.list());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<TarefaModel> getTarefa(@PathVariable String id) {
        return ResponseEntity.ok().body(tarefaController.getTarefa(id));
    }
    
    @GetMapping("/publicadas")
    public ResponseEntity<List<TarefasPublicadasModel>> listPublished() {
        return ResponseEntity.ok().body(tarefaController.listPublished());
    }

    @GetMapping("publicada/{id}")
    public ResponseEntity<TarefasPublicadasModel> getPublishTarefa(@PathVariable String id) {
        return ResponseEntity.ok().body(tarefaController.getPublishedTarefa(id));
    }

    @PostMapping
    public ResponseEntity<String> create(
        @Valid @RequestBody CreateTarefaRequest request) {
        
        String response = tarefaController.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    

    @PostMapping("{id}/publicacao")
    public ResponseEntity<Void> publish(
        @PathVariable String id,
        @Valid @RequestBody PublicacaoTarefaRequest entity) {
        tarefaController.publish(id, entity);
        return ResponseEntity.noContent().build();
    }
    

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        tarefaController.delete(id);
        return ResponseEntity.noContent().build();
    }
}

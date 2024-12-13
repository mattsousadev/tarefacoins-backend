package br.mattsousa.api.routes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mattsousa.api.controllers.TarefaController;
import br.mattsousa.data.models.TarefaModel;
import br.mattsousa.data.models.TarefasPublicadasModel;

@RestController
@RequestMapping("/tarefas")
public class TarefaRoute {

    @Autowired
    private TarefaController tarefaController;

    @GetMapping
    public ResponseEntity<List<TarefaModel>> list() {
        return ResponseEntity.ok().body(tarefaController.list());
    }
    
    @GetMapping("/publicadas")
    public ResponseEntity<List<TarefasPublicadasModel>> listPublished() {
        return ResponseEntity.ok().body(tarefaController.listPublished());
    }
}

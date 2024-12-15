package br.mattsousa.api.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mattsousa.api.controllers.RegraController;
import br.mattsousa.api.requests.CreateRegraRequest;
import br.mattsousa.data.models.RegraModel;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/regras")
public class RegraRoute {

    @Autowired
    private RegraController regraController;
    
    @GetMapping
    public ResponseEntity<List<RegraModel>> list() {
        return ResponseEntity.ok().body(regraController.list());
    }
    
    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody CreateRegraRequest request) {
        String response = regraController.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        regraController.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody CreateRegraRequest request) {
        regraController.update(id, request);
        return ResponseEntity.noContent().build();
    }
}

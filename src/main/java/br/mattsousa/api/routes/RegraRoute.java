package br.mattsousa.api.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mattsousa.api.controllers.RegraController;
import br.mattsousa.api.requests.CreateRegraRequest;
import br.mattsousa.data.models.RegraModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
    public ResponseEntity<String> create(@RequestBody CreateRegraRequest request) {
        String response = regraController.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
}

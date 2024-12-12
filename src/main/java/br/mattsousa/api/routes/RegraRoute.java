package br.mattsousa.api.routes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mattsousa.api.controllers.RegraController;
import br.mattsousa.data.models.RegraModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/regras")
public class RegraRoute {

    @Autowired
    private RegraController regraController;
    
    @GetMapping
    public ResponseEntity<List<RegraModel>> list() {
        return ResponseEntity.ok().body(regraController.list());
    }
    
}

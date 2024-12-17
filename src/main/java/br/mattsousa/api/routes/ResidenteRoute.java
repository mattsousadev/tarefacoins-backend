package br.mattsousa.api.routes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mattsousa.api.controllers.ResidenteController;
import br.mattsousa.data.models.ResidenteModel;

@RestController
@RequestMapping("/residentes")
public class ResidenteRoute {
    
    @Autowired
    public ResidenteController residenteController;

    @GetMapping
    public ResponseEntity<List<ResidenteModel>> list() {
        return ResponseEntity.ok().body(residenteController.list());
    }
}

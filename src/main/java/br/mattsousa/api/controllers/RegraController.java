package br.mattsousa.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.mattsousa.api.requests.CreateRegraRequest;
import br.mattsousa.data.models.RegraModel;
import br.mattsousa.domain.exceptions.RegraNotFoundException;
import br.mattsousa.domain.services.RegraService;

@Service
public class RegraController {

    @Autowired
    private RegraService regraService;

    public List<RegraModel> list() {
        return regraService.getAllRegras();
    }

    public String create(CreateRegraRequest request) {
        RegraModel newRegra = regraService.createRegra(request);
        return newRegra.getId();
    }

    public void delete(String id) {
        if (!regraService.checkRegraExists(id)){
            RegraNotFoundException e = new RegraNotFoundException("Registro não encontrado");
            e.setStatus(HttpStatus.NOT_FOUND);
            throw e;
        }
        regraService.deleteRegra(id);
    }

    public void update(String id, CreateRegraRequest request) {
        if (!regraService.checkRegraExists(id)){
            RegraNotFoundException e = new RegraNotFoundException("Registro não encontrado");
            e.setStatus(HttpStatus.NOT_FOUND);
            throw e;
        }
        regraService.updateRegra(id, request);
    }
    
}

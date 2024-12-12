package br.mattsousa.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.data.models.RegraModel;
import br.mattsousa.domain.services.RegraService;

@Service
public class RegraController {

    @Autowired
    private RegraService regraService;

    public List<RegraModel> list() {
        return regraService.getAllRegras();
    }
    
}

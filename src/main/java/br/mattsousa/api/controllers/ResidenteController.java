package br.mattsousa.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.data.models.ResidenteModel;
import br.mattsousa.domain.services.ResidenteService;

@Service
public class ResidenteController {

    @Autowired
    private ResidenteService residenteService;

    public List<ResidenteModel> list() {
        return residenteService.listResidente();
    }
    
}

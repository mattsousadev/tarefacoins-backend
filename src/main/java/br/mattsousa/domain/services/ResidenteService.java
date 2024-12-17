package br.mattsousa.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.data.models.ResidenteModel;
import br.mattsousa.data.repository.ResidenteRepository;

@Service
public class ResidenteService {

    @Autowired
    private ResidenteRepository residenteRepository;

    public List<ResidenteModel> listResidente() {
        return residenteRepository.findAll();
    }
    
}

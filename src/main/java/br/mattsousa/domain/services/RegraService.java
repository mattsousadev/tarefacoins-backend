package br.mattsousa.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.data.models.RegraModel;
import br.mattsousa.data.repository.RegraRepository;

@Service
public class RegraService {

    @Autowired
    private RegraRepository regraRepository;

    public List<RegraModel> getAllRegras() {
        return regraRepository.findAll();
    }
    
}

package br.mattsousa.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.api.requests.CreateRegraRequest;
import br.mattsousa.data.models.RegraModel;
import br.mattsousa.data.repository.RegraRepository;

@Service
public class RegraService {

    @Autowired
    private RegraRepository regraRepository;

    public List<RegraModel> getAllRegras() {
        return regraRepository.findAll();
    }

    public RegraModel createRegra(CreateRegraRequest request) {
        RegraModel newRegra = new RegraModel();
        newRegra.setNome(request.nome());
        return regraRepository.save(newRegra);
    }

    public void deleteRegra(String id) {
        regraRepository.deleteById(id);
    }

    public boolean checkRegraExists(String id) {
        return regraRepository.existsById(id);
    }

    public void updateRegra(String id, CreateRegraRequest request) {
        RegraModel regra = regraRepository.findById(id).get();
        regra.setNome(request.nome());
        regraRepository.save(regra);
    }

    public boolean checkIsApplied(String id) {
        return regraRepository.isApplied(id);
    }
    
}

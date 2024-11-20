package br.mattsousa.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.data.models.UsersModel;
import br.mattsousa.data.repository.UsersRepository;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public List<UsersModel> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<UsersModel> getUser(String id) {
        return usersRepository.findById(id);
    }
    
}

package br.mattsousa.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.data.models.UserModel;
import br.mattsousa.data.repository.UserRepository;

@Service
public class UsersService {

    @Autowired
    private UserRepository usersRepository;

    public List<UserModel> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<UserModel> getUser(String id) {
        return usersRepository.findById(id);
    }
    
}

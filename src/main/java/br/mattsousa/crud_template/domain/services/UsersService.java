package br.mattsousa.crud_template.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.mattsousa.crud_template.data.models.UserModel;
import br.mattsousa.crud_template.data.repository.UserRepository;

@Service
public class UsersService {

    private UserRepository usersRepository;

    public List<UserModel> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<UserModel> getUser(String id) {
        return usersRepository.findById(id);
    }
    
}

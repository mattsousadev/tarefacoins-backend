package br.mattsousa.crud_template.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.crud_template.data.models.UserModel;
import br.mattsousa.crud_template.data.repository.UserRepository;
import br.mattsousa.crud_template.exceptions.UserNotFoundException;

@Service
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> listAll() {
        return userRepository.findAll();
    }
    
    public UserModel getById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}

package br.mattsousa.crud_template.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.crud_template.data.models.UserModel;
import br.mattsousa.crud_template.domain.exceptions.UserNotFoundException;
import br.mattsousa.crud_template.domain.services.UsersService;

@Service
public class UsersController {

    @Autowired
    private UsersService usersService;

    public List<UserModel> listAll() {
        return usersService.getAllUsers();
    }
    
    public UserModel getById(String id) {
        Optional<UserModel> output = usersService.getUser(id);
        if(!output.isPresent())
            throw new UserNotFoundException("User not found");
        return output.get();
    }
}

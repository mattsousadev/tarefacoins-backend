package br.mattsousa.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.data.models.UsersModel;
import br.mattsousa.domain.exceptions.UserNotFoundException;
import br.mattsousa.domain.services.UsersService;

@Service
public class UsersController {

    @Autowired
    private UsersService usersService;

    public List<UsersModel> listAll() {
        return usersService.getAllUsers();
    }
    
    public UsersModel getById(String id) {
        Optional<UsersModel> output = usersService.getUser(id);
        if(!output.isPresent())
            throw new UserNotFoundException("User not found");
        return output.get();
    }
}

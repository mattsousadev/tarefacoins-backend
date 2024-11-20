package br.mattsousa.api.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.mattsousa.api.requests.CreateUsersRequest;
import br.mattsousa.api.requests.UpdateUserRequest;
import br.mattsousa.data.models.UsersModel;
import br.mattsousa.domain.exceptions.EmailAlreadyRegisteredException;
import br.mattsousa.domain.exceptions.InvalidDateFormatException;
import br.mattsousa.domain.exceptions.InvalidFileException;
import br.mattsousa.domain.exceptions.UserNotFoundException;
import br.mattsousa.domain.services.UsersService;
import br.mattsousa.utils.Utils;

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

    public UsersModel create(CreateUsersRequest request) {
        if(usersService.checkEmailExists(request.email()))
            throw new EmailAlreadyRegisteredException("Email already exists");
        if(!Utils.matchDateFormat(request.birthDate()))
            throw new InvalidDateFormatException("Invalid date format");
        return usersService.createUser(request);
    }

    public void delete(String id) {
        UsersModel user = getById(id);
        usersService.deleteUser(user);
    }

    public void update(String id, UpdateUserRequest request) {
        if(request.email() != null && usersService.checkEmailExists(request.email()))
            throw new EmailAlreadyRegisteredException("Email already exists");
        if(request.birthDate() != null && !Utils.matchDateFormat(request.birthDate()))
            throw new InvalidDateFormatException("Invalid date format");
        UsersModel user = getById(id);
        usersService.updateUser(user, request);
    }

    public void upload(String id, MultipartFile file) {
        UsersModel user = getById(id);
        byte[] fileBytes = null;
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            throw new InvalidFileException("Invalid file");
        }
        usersService.uploadFile(user, fileBytes);
    }
}

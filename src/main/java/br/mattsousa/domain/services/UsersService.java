package br.mattsousa.domain.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.mattsousa.api.requests.CreateUsersRequest;
import br.mattsousa.data.models.UsersModel;
import br.mattsousa.data.repository.UsersRepository;
import br.mattsousa.utils.Utils;

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

    public UsersModel createUser(CreateUsersRequest request) {
        UsersModel newUser = new UsersModel();
        LocalDate birthDate = Utils.getLocalDate(request.birthDate());
        Integer serialNumber = Utils.getSerialNumber();
        newUser.setName(request.name());
        newUser.setEmail(request.email());
        newUser.setIsActive(request.isActive() == null ? true : request.isActive());
        newUser.setSerialNumber(serialNumber);
        newUser.setBirthDate(birthDate);
        usersRepository.save(newUser);
        return newUser;
    }

    public boolean checkEmailExists(String email) {
        return usersRepository.findByEmail(email).isPresent();
    }

    public void deleteUser(UsersModel user) {
        usersRepository.delete(user);
    }
    
}

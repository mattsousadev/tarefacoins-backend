package br.mattsousa.api.routes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.mattsousa.api.controllers.UsersController;
import br.mattsousa.api.requests.CreateUsersRequest;
import br.mattsousa.api.requests.UpdateUserRequest;
import br.mattsousa.data.models.UsersModel;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/users")
public class UsersRoute {

    @Autowired
    private UsersController usersController;

    @GetMapping
    public ResponseEntity<List<UsersModel>> listAll() {
        return ResponseEntity.ok(usersController.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersModel> listById(@PathVariable String id) {
        return ResponseEntity.ok(usersController.getById(id));
    }

    @PostMapping
    public ResponseEntity<UsersModel> create(@Valid @RequestBody CreateUsersRequest request) {
        UsersModel output = usersController.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        usersController.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UpdateUserRequest request) {
        usersController.update(id, request);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity<Void> upload(@PathVariable String id,
        @RequestParam(required = true) MultipartFile file) {
        usersController.upload(id, file);
        return ResponseEntity.noContent().build();
    }
    
}

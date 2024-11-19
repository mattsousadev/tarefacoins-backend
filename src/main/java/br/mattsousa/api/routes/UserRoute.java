package br.mattsousa.api.routes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mattsousa.api.controllers.UsersController;
import br.mattsousa.data.models.UserModel;

@RestController
@RequestMapping("/users")
public class UserRoute {

    @Autowired
    private UsersController usersController;

    @GetMapping
    public ResponseEntity<List<UserModel>> listAll() {
        return ResponseEntity.ok(usersController.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> listById(@PathVariable String id) {
        return ResponseEntity.ok(usersController.getById(id));
    }
}

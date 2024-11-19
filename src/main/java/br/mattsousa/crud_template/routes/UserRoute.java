package br.mattsousa.crud_template.routes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.mattsousa.crud_template.controllers.UsersController;
import br.mattsousa.crud_template.data.models.UserModel;

@RestController
@RequestMapping("/users")
public class UserRoute {

    @Autowired
    private UsersController usersController;

    @GetMapping
    public ResponseEntity<List<UserModel>> listAll() {
        return ResponseEntity.ok(usersController.listAll());
    }

}

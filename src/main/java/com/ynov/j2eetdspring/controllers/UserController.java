package com.ynov.j2eetdspring.controllers;

import com.ynov.j2eetdspring.entities.User;
import com.ynov.j2eetdspring.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Récupération d'un utilisateur par son identifiant")
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable(name = "id") Long id_user){
        return userService.getUserById(id_user);
    }

    @Operation(summary = "Création ou Modification d'un utilisateur")
    @RequestMapping(method = RequestMethod.PUT)
    public User createOrUpdate(@RequestBody User user){
        return userService.createOrUpdate(user);
    }

    @Operation(summary = "Récupération de tous les utilisateurs")
    @RequestMapping(path = "/_all", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Suppression d'un utilisateur à partir de son identifiant")
            @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteUserById(id);
    }

    @Operation(summary = "Récupération de tous les utilisateurs dans une page")
    @RequestMapping(method = RequestMethod.GET)
    public Page<User> getUsers(Pageable pageable) {
        return userService.getUsersWithPaging(pageable);
    }

}

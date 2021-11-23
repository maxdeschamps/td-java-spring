package com.j2ee.tdspring.controllers;

import com.j2ee.tdspring.entities.User;
import com.j2ee.tdspring.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/add-test-user", method = RequestMethod.GET)
    @Valid
    public void addTestUser() {
        User user = new User();
        user.setUsername("jptest");
        user.setFirstname("Jean Pierre");
        user.setLastname("Test");
        user.setTelephone("0610203040");
        user.setRole("ADMIN");
        userService.createOrUpdate(user);
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id") String username) {
        return userService.getUserById(username);
    }

    @Operation(summary = "Création ou mise à jour d'un utilisateur")
    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    public User addOrUpdateUser(@Valid @RequestBody User user) {
        return userService.createOrUpdate(user);
    }

    @Operation(summary = "Récupération de tous les utilisateurs")
    @RequestMapping(path = "/users/all", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Suppression d'un utilisateur à partir de son identifiant")
    @RequestMapping(path = "/user", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam(value = "id") String username) {
        userService.deleteUser(userService.getUserById(username));
    }

    @Operation(summary = "Mise à jour du mot de passe d'un utilisateur")
    @RequestMapping(path = "/user/updatePassword", method = RequestMethod.GET)
    public void setPassword(@RequestParam(value = "userName") String userName,
                            @RequestParam(value = "old") String oldPassword,
                            @RequestParam(value = "new") String newPassword) throws
            IllegalAccessException {
        userService.setPassword(userName, oldPassword, newPassword);
    }
}

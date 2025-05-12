package com.desafio.neki.controllers;

import com.desafio.neki.models.User;
import com.desafio.neki.repositories.UserRepository;
import com.desafio.neki.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "List Users", description = "Endpoint para listar todos os usuários")
    @ApiResponse(responseCode = "200", description = "Usuários listados com sucesso")
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok(userService.listUsers());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get User by ID", description = "Endpoint para buscar um usuário pelo id")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get User by Email", description = "Endpoint para buscar um usuário pelo email")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }
    @GetMapping("/username/{username}")
    @Operation(summary = "Get User by Username", description = "Endpoint para buscar um usuário pelo username")
    @ApiResponse(responseCode = "200", description = "Usuário encontrado com sucesso")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @PostMapping("/create")
    @Operation(summary = "Create User", description = "Endpoint para criar um usuário")
    @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        return ResponseEntity.status(201).body(userService.createUser(user));
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete User", description = "Endpoint para deletar um usuário pelo id")
    @ApiResponse(responseCode = "204", description = "Usuário deletado com sucesso")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

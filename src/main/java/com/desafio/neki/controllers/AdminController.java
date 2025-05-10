package com.desafio.neki.controllers;

import com.desafio.neki.dtos.AdminDto;
import com.desafio.neki.services.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    @Operation(summary = "Create Admin", description = "Endpoint para criar um admin")
    @ApiResponse(responseCode = "201", description = "Admin criado com sucesso")
    public ResponseEntity<AdminDto> createAdmin(@Valid @RequestBody AdminDto adminDto) {
        AdminDto admin = adminService.createAdmin(adminDto);
        return ResponseEntity.status(201).body(admin);
    }

    @GetMapping
    @Operation(summary = "List Admins", description = "Endpoint para listar todos os admins")
    @ApiResponse(responseCode = "200", description = "Admins listados com sucesso")
    public ResponseEntity<List<AdminDto>> listAdmins() {
        List<AdminDto> admins = adminService.listAdmins();
        return ResponseEntity.ok(admins);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Admin by ID", description = "Endpoint para buscar um admin pelo id")
    @ApiResponse(responseCode = "200", description = "Admin encontrado com sucesso")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable Long id) {
        AdminDto admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Admin", description = "Endpoint para atualizar um admin pelo id")
    @ApiResponse(responseCode = "200", description = "Admin atualizado com sucesso")
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable Long id, @Valid @RequestBody AdminDto adminDto) {
        AdminDto admin = adminService.updateAdmin(id, adminDto);
        return ResponseEntity.ok(admin);
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get Admin by Email", description = "Endpoint para buscar um admin pelo email")
    @ApiResponse(responseCode = "200", description = "Admin encontrado com sucesso")
    public ResponseEntity<AdminDto> getAdminByEmail(@PathVariable String email) {
        AdminDto admin = adminService.getAdminByEmail(email);
        return ResponseEntity.ok(admin);
    }
}

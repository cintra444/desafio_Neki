package com.desafio.neki.services;

import com.desafio.neki.dtos.AdminDto;
import com.desafio.neki.exception.ResourceNotFoundException;
import com.desafio.neki.models.Admin;
import com.desafio.neki.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public AdminDto createAdmin(AdminDto adminDto) {

        Admin admin = new Admin();
        admin.setName(adminDto.name());
        admin.setEmail(adminDto.email());
        admin.setPassword(adminDto.password());
        admin = adminRepository.save(admin);
        return AdminDto.toDto(admin);
    }

    public List<AdminDto> listAdmins() {
        return adminRepository.findAll().stream().map(AdminDto::toDto).toList();
    }

    public AdminDto getAdminById(Long id) {
        return adminRepository.findById(Math.toIntExact(id)).map(AdminDto::toDto).orElseThrow(() -> new ResourceNotFoundException("Administrador nao encontrado: " , "Id not found"));
    }

    public AdminDto updateAdmin(Long id, AdminDto adminDto) {
        Admin admin = adminRepository.findById(Math.toIntExact(id)).orElseThrow(() -> new ResourceNotFoundException("Administrador nao encontrado: ", "Id not found"));
        if (admin == null) {
            throw new ResourceNotFoundException("Administrador nao encontrado: ","ADMIN_NOT_FOUND");
        }

        admin.setName(adminDto.name());
        admin.setEmail(adminDto.email());
        admin = adminRepository.save(admin);
        return AdminDto.toDto(admin);
    }

    public AdminDto getAdminByEmail(String email) {
        return Optional.ofNullable(adminRepository.findByEmail(email))
                .map(AdminDto::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Administrador não encontrado","Email not found"));
    }
}

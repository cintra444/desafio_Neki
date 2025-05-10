package com.desafio.neki.services;

import com.desafio.neki.dtos.AdminDto;
import com.desafio.neki.exception.AuthenticationException;
import com.desafio.neki.models.Admin;
import com.desafio.neki.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdminDto autenticar(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);

        if (admin == null || !passwordEncoder.matches(password, admin.getPassword())) {
            throw new AuthenticationException("Usuário ou senha inválidos", "AUTH_FAILED");
        }

        return AdminDto.toDto(admin);
    }
}

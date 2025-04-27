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
    private AdminRepository adimRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Object autenticar(String email, String password) {

        Admin admin = adimRepository.findByEmail(email);

        if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
            return new AdminDto(admin.getId(), admin.getName(), admin.getEmail());
        }
        throw new AuthenticationException("AUTH_FAILED", "Usuário ou senha inválidos");
    }


}

package com.desafio.neki.dtos;

import com.desafio.neki.models.Admin;

public record AdminDto(
    Integer id,
    String name,
    String email,
    String password
) {
    public Admin toEntity() {
        Admin admin = new Admin();
        admin.setId(id);
        admin.setName(name);
        admin.setEmail(email);
        admin.setPassword(password);
        return admin;
    }

    public static AdminDto toDto(Admin admin) {
        return new AdminDto(
                admin.getId(),
                admin.getName(),
                admin.getEmail(),
                null
        );
    }

}

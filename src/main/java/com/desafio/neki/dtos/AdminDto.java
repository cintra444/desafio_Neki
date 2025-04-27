package com.desafio.neki.dtos;

import com.desafio.neki.models.Admin;

public record AdminDto(
    Long id,
    String name,
    String email
) {
    public Admin toEntity() {
        Admin admin = new Admin();
        admin.setId(id);
        admin.setName(name);
        admin.setEmail(email);

        return admin;
    }

    public static AdminDto toDto(Admin admin) {
        return new AdminDto(
                admin.getId(),
                admin.getName(),
                admin.getEmail()
        );
    }

}

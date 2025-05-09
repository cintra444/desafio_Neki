package com.desafio.neki.repositories;

import com.desafio.neki.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {


    Admin findByEmail(String email);


}

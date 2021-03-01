package com.jsprest.repository;

import com.jsprest.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByEmail(String email);

    Admin findByUsername(String username);

    Admin findByPassword(String password);
}

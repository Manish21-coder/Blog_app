package com.blog2.blog_app.repository;

import com.blog2.blog_app.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(String name);

}

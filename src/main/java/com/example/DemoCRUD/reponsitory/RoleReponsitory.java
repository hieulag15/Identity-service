package com.example.DemoCRUD.reponsitory;

import com.example.DemoCRUD.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleReponsitory extends JpaRepository<Role, String> {
}

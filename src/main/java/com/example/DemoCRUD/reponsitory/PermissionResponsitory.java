package com.example.DemoCRUD.reponsitory;

import com.example.DemoCRUD.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionResponsitory extends JpaRepository<Permission, String> {

}

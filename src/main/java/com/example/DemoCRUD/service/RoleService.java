package com.example.DemoCRUD.service;

import com.example.DemoCRUD.dto.request.RoleRequest;
import com.example.DemoCRUD.dto.response.RoleResponse;
import com.example.DemoCRUD.mapper.RoleMapper;
import com.example.DemoCRUD.reponsitory.PermissionResponsitory;
import com.example.DemoCRUD.reponsitory.RoleReponsitory;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class RoleService {
    RoleReponsitory roleReponsitory;
    RoleMapper roleMapper;
    PermissionResponsitory permissionResponsitory;


    public RoleResponse create(RoleRequest request) {
        var role = roleMapper.toRole(request);

        var permissions = permissionResponsitory.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleReponsitory.save(role);
        return roleMapper.toRoleResponse(role);
    }

    public List<RoleResponse> getAll() {
        var roles = roleReponsitory.findAll();
        return roles.stream()
                .map(roleMapper::toRoleResponse)
                .toList();
    }

    public void delete(String role) {
        roleReponsitory.deleteById(role);
    }
}

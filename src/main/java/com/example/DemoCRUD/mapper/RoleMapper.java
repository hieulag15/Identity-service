package com.example.DemoCRUD.mapper;

import com.example.DemoCRUD.dto.request.PermissionRequest;
import com.example.DemoCRUD.dto.request.RoleRequest;
import com.example.DemoCRUD.dto.response.PermissionResponse;
import com.example.DemoCRUD.dto.response.RoleResponse;
import com.example.DemoCRUD.entity.Permission;
import com.example.DemoCRUD.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest roleRequest);
    RoleResponse toRoleResponse(Role role);
}

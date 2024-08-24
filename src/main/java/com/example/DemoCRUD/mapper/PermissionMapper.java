package com.example.DemoCRUD.mapper;

import com.example.DemoCRUD.dto.request.PermissionRequest;
import com.example.DemoCRUD.dto.request.UserCreationRequest;
import com.example.DemoCRUD.dto.request.UserUpdateRequest;
import com.example.DemoCRUD.dto.response.PermissionResponse;
import com.example.DemoCRUD.dto.response.UserResponse;
import com.example.DemoCRUD.entity.Permission;
import com.example.DemoCRUD.entity.Role;
import com.example.DemoCRUD.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest permissionRequest);
    PermissionResponse toPermissionResponse(Permission permission);
}

package com.example.DemoCRUD.service;

import com.example.DemoCRUD.dto.request.PermissionRequest;
import com.example.DemoCRUD.dto.response.PermissionResponse;
import com.example.DemoCRUD.entity.Permission;
import com.example.DemoCRUD.mapper.PermissionMapper;
import com.example.DemoCRUD.reponsitory.PermissionResponsitory;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class PermissionService {
    PermissionResponsitory permissionResponsitory;
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionResponsitory.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> getAll(){
        var permissions = permissionResponsitory.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void delete(String permission){
        permissionResponsitory.deleteById(permission);
    }
}

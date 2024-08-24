package com.example.DemoCRUD.controller;

import com.example.DemoCRUD.dto.request.ApiResponse;
import com.example.DemoCRUD.dto.request.PermissionRequest;
import com.example.DemoCRUD.dto.request.RoleRequest;
import com.example.DemoCRUD.dto.response.RoleResponse;
import com.example.DemoCRUD.dto.response.RoleResponse;
import com.example.DemoCRUD.service.PermissionService;
import com.example.DemoCRUD.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }


    @GetMapping
    ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{role}")
    ApiResponse<Void> delete(@PathVariable String role) {
        roleService.delete(role);
        return ApiResponse.<Void>builder().build();
    }
}

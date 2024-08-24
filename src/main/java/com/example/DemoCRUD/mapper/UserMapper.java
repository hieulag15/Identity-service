package com.example.DemoCRUD.mapper;

import com.example.DemoCRUD.dto.request.UserCreationRequest;
import com.example.DemoCRUD.dto.request.UserUpdateRequest;
import com.example.DemoCRUD.dto.response.UserResponse;
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
public interface UserMapper {
    User toUser(UserCreationRequest userCreationRequest);

    @Mapping(source = "roles", target = "roles", qualifiedByName = "rolesToStrings")
    UserResponse toUserResponse(User user);
    List<UserResponse> toUserResponses(List<User> users);
    void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);

    @Named("rolesToStrings")
    default Set<String> rolesToStrings(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName) // Assuming Role has a getName() method
                .collect(Collectors.toSet());
    }
}

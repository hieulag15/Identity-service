package com.example.DemoCRUD.mapper;

import com.example.DemoCRUD.dto.request.UserCreationRequest;
import com.example.DemoCRUD.dto.request.UserUpdateRequest;
import com.example.DemoCRUD.dto.response.UserResponse;
import com.example.DemoCRUD.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest userCreationRequest);
    UserResponse toUserResponse(User user);
    List<UserResponse> toUserResponses(List<User> users);
    void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}

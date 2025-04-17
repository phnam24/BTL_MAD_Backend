package com.example.btl_mad_backend.mapper;

import com.example.btl_mad_backend.dto.user.BasicUserDTO;
import com.example.btl_mad_backend.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    BasicUserDTO userToBasicUserDTO(User user);
}

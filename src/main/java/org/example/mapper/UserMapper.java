package org.example.mapper;

import org.example.model.User;
import org.example.model.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User>{
}

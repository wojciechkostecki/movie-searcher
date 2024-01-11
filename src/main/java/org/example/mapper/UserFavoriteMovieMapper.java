package org.example.mapper;

import org.example.model.UserFavoriteMovie;
import org.example.model.dto.UserFavoriteMovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface UserFavoriteMovieMapper extends EntityMapper<UserFavoriteMovieDTO, UserFavoriteMovie>{

    @Mapping(source = "user.id", target = "userId")
    UserFavoriteMovieDTO toDto(UserFavoriteMovie userFavoriteMovie);

    @Mapping(source = "userId", target = "user")
    UserFavoriteMovie toEntity(UserFavoriteMovieDTO dto);
}

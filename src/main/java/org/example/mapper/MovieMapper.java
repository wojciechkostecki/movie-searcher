package org.example.mapper;

import org.example.model.dto.MovieDTO;
import org.example.service.omdb.OmdbResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieDTO omdbResponseToMovie(OmdbResponse omdbResponse);
}

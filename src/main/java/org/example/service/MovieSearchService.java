package org.example.service;

import org.example.exception.MovieSearchException;
import org.example.mapper.MovieMapper;
import org.example.model.dto.MovieDTO;
import org.example.service.omdb.OmdbResponse;
import org.example.service.omdb.OmdbService;
import org.springframework.stereotype.Service;

@Service
public class MovieSearchService {

    private final OmdbService omdbService;

    private final MovieMapper movieMapper;

    public MovieSearchService(OmdbService omdbService, MovieMapper movieMapper) {
        this.omdbService = omdbService;
        this.movieMapper = movieMapper;
    }

    public MovieDTO findMovieByTitle(String title) {
        OmdbResponse omdbResponse = omdbService.findMovieByTitle(title);

        if (Boolean.parseBoolean(omdbResponse.getResponse())) {
            return movieMapper.omdbResponseToMovie(omdbResponse);
        } else {
            throw new MovieSearchException(omdbResponse.getError());
        }
    }


}

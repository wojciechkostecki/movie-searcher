package org.example.controller;

import org.example.model.dto.MovieDTO;
import org.example.service.MovieSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieSearchController {

    private final MovieSearchService movieSearchService;

    public MovieSearchController(MovieSearchService movieSearchService) {
        this.movieSearchService = movieSearchService;
    }

    @GetMapping("/by-title/{title}")
    public ResponseEntity<MovieDTO> findMovieByTitle(@PathVariable String title) {
        return ResponseEntity.ok(movieSearchService.findMovieByTitle(title));
    }
}

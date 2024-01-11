package org.example.controller;

import org.example.model.dto.UserFavoriteMovieDTO;
import org.example.service.UserFavoriteMovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/favorite-movies")
public class UserFavoriteMovieController {

    private final UserFavoriteMovieService userFavoriteMovieService;

    public UserFavoriteMovieController(UserFavoriteMovieService userFavoriteMovieService) {
        this.userFavoriteMovieService = userFavoriteMovieService;
    }

    @PostMapping
    public ResponseEntity<UserFavoriteMovieDTO> createUserFavoriteMovie(@RequestBody UserFavoriteMovieDTO dto) {
        return ResponseEntity.ok(userFavoriteMovieService.save(dto));
    }

    @PutMapping
    public ResponseEntity<UserFavoriteMovieDTO> updateUserFavoriteMovie(@RequestBody UserFavoriteMovieDTO dto) {
        return ResponseEntity.ok(userFavoriteMovieService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<UserFavoriteMovieDTO>> getAllUserFavoriteMovies() {
        return ResponseEntity.ok(userFavoriteMovieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFavoriteMovieDTO> getUserFavoriteMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(userFavoriteMovieService.findById(id).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserFavoriteMovieById(@PathVariable Long id) {
        userFavoriteMovieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

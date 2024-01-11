package org.example.service;

import org.example.mapper.UserFavoriteMovieMapper;
import org.example.model.UserFavoriteMovie;
import org.example.model.dto.UserFavoriteMovieDTO;
import org.example.repository.UserFavoriteMovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserFavoriteMovieService {

    private final UserFavoriteMovieRepository userFavoriteMovieRepository;

    private final UserFavoriteMovieMapper userFavoriteMovieMapper;

    public UserFavoriteMovieService(UserFavoriteMovieRepository userFavoriteMovieRepository,
                                    UserFavoriteMovieMapper userFavoriteMovieMapper) {
        this.userFavoriteMovieRepository = userFavoriteMovieRepository;
        this.userFavoriteMovieMapper = userFavoriteMovieMapper;
    }

    public UserFavoriteMovieDTO save(UserFavoriteMovieDTO dto) {
        UserFavoriteMovie userFavoriteMovie = userFavoriteMovieRepository.save(userFavoriteMovieMapper.toEntity(dto));
        return userFavoriteMovieMapper.toDto(userFavoriteMovie);
    }

    public List<UserFavoriteMovieDTO> findAll() {
        return userFavoriteMovieRepository.findAll().stream()
                .map(userFavoriteMovieMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<UserFavoriteMovieDTO> findById(Long id) {
        return userFavoriteMovieRepository.findById(id)
                .map(userFavoriteMovieMapper::toDto);
    }

    public void delete(Long id) {
        userFavoriteMovieRepository.deleteById(id);
    }
}

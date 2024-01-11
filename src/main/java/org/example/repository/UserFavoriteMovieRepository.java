package org.example.repository;


import org.example.model.UserFavoriteMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavoriteMovieRepository extends JpaRepository<UserFavoriteMovie, Long> {
}

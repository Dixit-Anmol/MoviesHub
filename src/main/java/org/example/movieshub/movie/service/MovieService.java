package org.example.movieshub.movie.service;

import org.example.movieshub.movie.exceptions.MovieNotFoundException;
import org.example.movieshub.movie.exceptions.MovieValidationException;
import org.example.movieshub.movie.model.Movie;
import java.util.List;

/**
 * Service interface for Movie operations
 */
public interface MovieService {
    Movie addMovie(Movie movie) throws MovieValidationException;
    Movie getMovieById(Long id) throws MovieNotFoundException;
    List<Movie> getAllMovies() throws MovieNotFoundException;
    List<Movie> getMovieByTitle(String title) throws MovieNotFoundException;
    List<Movie> getMovieByReleaseYear(int releaseYear) throws MovieNotFoundException;
    List<Movie> findByGenre(String genre) throws MovieNotFoundException;
    Movie updateMovie(Long id, Movie movie) throws MovieNotFoundException, MovieValidationException;
    void deleteMovie(Long id) throws MovieNotFoundException;
}


// show all movies by rating
package org.example.movieshub.movie.service;

import org.example.movieshub.movie.exceptions.MovieNotFoundException;
import org.example.movieshub.movie.exceptions.MovieValidationException;
import org.example.movieshub.movie.model.Movie;
import org.example.movieshub.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A service that uses a database to store and manage movie information.
 * This class handles all database-related logic for Movie entities.
 */
@Service
public class DatabaseMovieService {

    private final MovieRepository movieRepository;

    /**
     * Constructor-based injection for MovieRepository.
     *
     * @param movieRepository the repository to perform database operations
     */
    @Autowired
    public DatabaseMovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     * Adds a new movie to the database.
     *
     * @param movie the movie to add
     * @return the saved movie with a generated ID
     */
    public Movie addMovie(Movie movie) {
        if (movie == null) {
            throw new MovieValidationException("Movie must not be null");
        }
        return movieRepository.save(movie);
    }

    /**
     * Retrieves all movies from the database.
     *
     * @return list of all movies
     */
    public List<Movie> getAllMovies() {
        List<Movie> movieList = movieRepository.findAll();
        if (movieList.isEmpty()) {
            throw new MovieNotFoundException("No movies found");
        }
        return movieList;
    }

    /**
     * Gets a movie by its ID.
     *
     * @param id the ID of the movie
     * @return the movie if found
     */
    public Movie getMovieById(long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie with id " + id + " not found"));
    }

    /**
     * Gets a movie by its title.
     *
     * @param title the title of the movie
     * @return the movie if found
     */
    public Movie getMovieByTitle(String title) {
        return movieRepository.findByTitle(title)
                .orElseThrow(() -> new MovieNotFoundException("Movie with title '" + title + "' not found"));
    }

    /**
     * Updates the rating of a movie.
     *
     * @param id     the movie ID
     * @param rating the new rating
     * @return the updated movie
     */
    public Movie updateMovieRating(long id, double rating) {
        if (rating < 0 || rating > 10) {
            throw new MovieValidationException("Rating must be between 0 and 10");
        }
        Movie movie = getMovieById(id);
        movie.setRating(rating);
        return movieRepository.save(movie);
    }

    /**
     * Updates the genre of a movie.
     *
     * @param id    the movie ID
     * @param genre the new genre
     * @return the updated movie
     */
    public Movie updateMovieGenre(long id, String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            throw new MovieValidationException("Genre must not be null or empty");
        }
        Movie movie = getMovieById(id);
        movie.setGenre(genre);
        return movieRepository.save(movie);
    }

    /**
     * Deletes a movie from the database.
     *
     * @param id the ID of the movie to delete
     * @return true if deleted, otherwise false
     */
    public boolean deleteMovie(long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        } else {
            throw new MovieNotFoundException("Movie with id " + id + " not found");
        }
    }
}

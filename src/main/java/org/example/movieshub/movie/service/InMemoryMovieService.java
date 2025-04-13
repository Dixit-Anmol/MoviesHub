package org.example.movieshub.movie.service;

import org.example.movieshub.movie.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing Movie operations in memory.
 * This class handles business logic for in-memory storage (SRP).
 */
@Service
public class InMemoryMovieService {

    private final List<Movie> movies;

    public InMemoryMovieService() {
        this.movies = new ArrayList<>();
    }

    /**
     * Adds a new movie to the list.
     *
     * @param movie The movie to be added
     * @return The added movie
     */
    public Movie addMovie(Movie movie) {
        movies.add(movie);
        return movie;
    }

    /**
     * Returns all movies.
     *
     * @return List of all movies
     */
    public List<Movie> getAllMovies() {
        return movies;
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id The movie ID
     * @return The found movie or null if not found
     */
    public Movie getMovieById(long id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    /**
     * Retrieves a list of movies by their release year.
     *
     * @param releaseYear The release year to filter by
     * @return A list of movies released in the given year
     */
    public List<Movie> getMoviesByReleaseYear(String releaseYear) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getYear() == releaseYear) {
                result.add(movie);
            }
        }
        return result;
    }


    /**
     * Finds a movie by title.
     *
     * @param title Movie title
     * @return The found movie or null if not found
     */
    public Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    /**
     * Updates the rating of a movie by its ID.
     *
     * @param id     The movie ID
     * @param rating New rating
     * @return Updated movie or null if not found
     */
    public Movie updateRating(long id, double rating) {
        Movie movie = getMovieById(id);
        if (movie != null) {
            movie.setRating(rating);
        }
        return movie;
    }

    /**
     * Updates the genre of a movie.
     *
     * @param id    The movie ID
     * @param genre New genre
     * @return Updated movie or null if not found
     */
    public Movie updateGenre(long id, String genre) {
        Movie movie = getMovieById(id);
        if (movie != null) {
            movie.setGenre(genre);
        }
        return movie;
    }

    /**
     * Deletes a movie by ID.
     *
     * @param id The movie ID
     * @return true if deleted, false otherwise
     */
    public boolean deleteMovie(long id) {
        Movie movie = getMovieById(id);
        if (movie != null) {
            movies.remove(movie);
            return true;
        }
        return false;
    }
}

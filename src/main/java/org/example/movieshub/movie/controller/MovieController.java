package org.example.movieshub.movie.controller;

import org.example.movieshub.movie.model.Movie;
import org.example.movieshub.movie.service.DatabaseMovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
@Validated
public class MovieController {

    private final DatabaseMovieService movieService;

    public MovieController(DatabaseMovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Adds a new movie.
     *
     * @param movie The movie to be added
     * @return The added movie
     */
    @PostMapping
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {
        Movie savedMovie = movieService.addMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    /**
     * Retrieves all movies.
     *
     * @return List of all movies
     */
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    /**
     * Retrieves a movie by ID.
     *
     * @param id The movie ID
     * @return The found movie
     */
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable @Positive long id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    /**
     * Retrieves a movie by its title.
     *
     * @param title The movie title
     * @return The found movie
     */
    @GetMapping("/byTitle")
    public ResponseEntity<Movie> getMovieByTitle(@RequestParam @Size(min = 1) String title) {
        Movie movie = movieService.getMovieByTitle(title);
        return ResponseEntity.ok(movie);
    }

    /**
     * Updates the rating of a movie by its ID.
     *
     * @param id     The movie ID
     * @param rating New rating for the movie
     * @return Updated movie
     */
    @PutMapping("/{id}/rating")
    public ResponseEntity<Movie> updateRating(
            @PathVariable @Positive long id,
            @RequestParam @Min(0) double rating) {
        Movie updatedMovie = movieService.updateMovieRating(id, rating);
        return ResponseEntity.ok(updatedMovie);
    }

    /**
     * Updates the genre of a movie by its ID.
     *
     * @param id    The movie ID
     * @param genre New genre for the movie
     * @return Updated movie
     */
    @PutMapping("/{id}/genre")
    public ResponseEntity<Movie> updateGenre(
            @PathVariable @Positive long id,
            @RequestParam @Size(min = 1) String genre) {
        Movie updatedMovie = movieService.updateMovieGenre(id, genre);
        return ResponseEntity.ok(updatedMovie);
    }

    /**
     * Deletes a movie by ID.
     *
     * @param id The movie ID
     * @return Response message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable @Positive long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully");
    }
}

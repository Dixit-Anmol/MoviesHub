package org.example.movieshub.movie.repository;

import org.example.movieshub.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing {@link Movie} entities in the database.
 * <p>
 * This interface extends {@link JpaRepository}, which provides standard CRUD operations:
 * <ul>
 *     <li>{@code save(Movie entity)}: Saves a movie to the database</li>
 *     <li>{@code findById(Long id)}: Finds a movie by its ID</li>
 *     <li>{@code findAll()}: Retrieves all movies</li>
 *     <li>{@code deleteById(Long id)}: Deletes a movie by ID</li>
 *     <li>{@code count()}: Returns total number of movies</li>
 *     <li>{@code existsById(Long id)}: Checks if a movie with the given ID exists</li>
 * </ul>
 * <p>
 * The {@code @Repository} annotation marks this interface as a Spring Data repository,
 * allowing Spring to find and configure it automatically.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    /**
     * Finds a movie by its title.
     * <p>
     * This method returns an {@link Optional} to prevent null pointer exceptions.
     *
     * @param title the title of the movie
     * @return an Optional containing the found movie, or empty if not found
     */
    Optional<Movie> findByTitle(String title);

    /**
     * Finds all movies with a rating greater than the specified value.
     *
     * @param rating the minimum rating
     * @return a list of movies with rating greater than the specified value
     */
    List<Movie> findByRatingGreaterThan(double rating);

    /**
     * Finds all movies of a given genre (case-insensitive match).
     *
     * @param genre the genre to search for
     * @return a list of movies that match the given genre
     */
    List<Movie> findByGenreIgnoreCase(String genre);

    /**
     * Finds movies whose title contains the given keyword (case-insensitive).
     * Useful for search functionality.
     *
     * @param keyword the keyword to search in movie titles
     * @return a list of matching movies
     */
    List<Movie> findByTitleContainingIgnoreCase(String keyword);

    /**
     * Finds movies released between two given years (inclusive),
     * sorted by year in ascending order.
     *
     * @param startYear starting year
     * @param endYear   ending year
     * @return a list of movies released in the specified year range
     */
    @Query("SELECT m FROM Movie m WHERE m.year BETWEEN ?1 AND ?2 ORDER BY m.year ASC")
    List<Movie> findMoviesByYearRange(int startYear, int endYear);
}

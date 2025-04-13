package org.example.movieshub.movie.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.util.Objects;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The title of the movie.
     * Cannot be blank, must be between 3 and 100 characters.
     */
    @NotBlank(message = "Movie title is required.")
    @Size(min = 3, max = 100, message = "Title must be between 1 and 100 characters.")
    @Column(nullable = false)
    private String title;

    /**
     * The release year of the movie.
     * Cannot be blank, must be 4 digits.
     */
    @NotBlank(message = "Release year is required.")
    @Pattern(regexp = "\\d{4}", message = "Year must be a 4-digit number.")
    @Column(nullable = false)
    private String year;

    /**
     * The genre(s) of the movie.
     * Cannot be blank. Letters, spaces, and commas allowed.
     */
    @NotBlank(message = "Genre is required.")
    @Column(nullable = false)
    private String genre;

    /**
     * A short description of the movie.
     * Cannot be blank, must be between 10 and 300 characters.
     */
    @NotBlank(message = "Description is required.")
    @Size(min = 10, max = 300, message = "Description must be between 10 and 300 characters.")
    @Column(nullable = false)
    private String description;

    /**
     * Rating of the movie.
     * Must be between 0.0 and 10.0.
     */
    @NotNull(message = "Rating is required.")
    @DecimalMin(value = "0.0", message = "Rating must be at least 0.0")
    @DecimalMax(value = "10.0", message = "Rating cannot exceed 10.0")
    @Column(nullable = false)
    private double rating;

    /**
     * The URL of the movie's poster or image.
     */
    @NotBlank(message = "Image URL is required.")
    @URL(message = "Please provide a valid image URL.")
    @Column(nullable = false)
    private String imageUrl;

    public Movie() {
    }

    public Movie(String title, String year, String genre, String description, double rating, String imageUrl) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.description = description;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;
        return id == movie.id &&
                Double.compare(rating, movie.rating) == 0 &&
                Objects.equals(title, movie.title) &&
                Objects.equals(year, movie.year) &&
                Objects.equals(genre, movie.genre) &&
                Objects.equals(description, movie.description) &&
                Objects.equals(imageUrl, movie.imageUrl);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(year);
        result = 31 * result + Objects.hashCode(genre);
        result = 31 * result + Objects.hashCode(description);
        result = 31 * result + Double.hashCode(rating);
        result = 31 * result + Objects.hashCode(imageUrl);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

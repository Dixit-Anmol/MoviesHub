package org.example.movieshub.movie.exceptions;

public class MovieValidationException extends RuntimeException {
    public MovieValidationException(String message) {
        super(message);
    }
}

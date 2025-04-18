# 🎬 MoviesHub – Backend System

MoviesHub is a backend system developed using Java to manage a list of movies. It supports basic CRUD (Create, Read, Update, Delete) operations, search functionality, and follows clean architecture principles like the **Single Responsibility Principle**. The application supports both **in-memory** and **database-based** movie storage.

## 📌 Features

- Add, update, delete, and search movies
- Store data in memory or in a MySQL database
- Clean and modular architecture
- Easy to switch between data storage implementations
- Basic HTML/CSS frontend (optional)
- Postman API test-ready

## 🚀 Technologies Used

- Java
- JDBC
- MySQL (Optional)
- Maven
- HTML/CSS (for UI)
- Postman (for API testing)
- Git & GitHub

## 📁 Project Structure

```
com.movieshub
├── controller              # Handles API requests
├── model                   # Defines Movie class
├── repository              # Interfaces for data access
├── service                 # Business logic and service classes
└── MainApplication.java    # Entry point of the application
```

## 🧠 Core Classes

- `Movie.java` – Model class representing movie details
- `MovieService.java` – Interface defining movie operations
- `InMemoryMovieService.java` – Implementation storing movies in memory
- `DatabaseMovieService.java` – Implementation using JDBC with MySQL
- `MovieController.java` – Acts as a controller layer to simulate API requests

## 🛠️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Dixit-Anmol/MoviesHub.git
   cd MoviesHub
   ```

2. Open the project in your favorite IDE (e.g., IntelliJ IDEA or Eclipse).

3. Set up your MySQL database (if using `DatabaseMovieService`) and update the JDBC credentials.

4. Run the `MainApplication.java` file.

5. Test the functionality via:
   - Console outputs
   - Postman (manually invoking controller methods)

## ✅ Sample Operations

- Add a movie
- View all movies
- Search movie by ID or title
- Update movie details
- Delete a movie

## 🧾 Screenshots

![alt text](image.png)
![alt text](image-1.png)
![alt text](image-2.png)

## 🙌 Acknowledgements

Special thanks to **Divyansh Bhardwaj** and **Neeraj Goyal** for their guidance and encouragement throughout the project.  
Thanks also to our HOD, mentors, and faculty members of ITM University, Gwalior.

## 📌 Future Enhancements

- Integrate with a REST API using Spring Boot
- Add user authentication and authorization
- Connect to a full-featured frontend (React/Angular)
- Deploy to cloud platforms like Heroku, Vercel, or AWS

## 📄 License

This project is for educational purposes. You are free to use and modify it.

# Blog Application Backend

This repository contains the backend implementation for a blog application, providing RESTful APIs for managing users, posts, and comments.

## Features

- **Authentication:** The application provides secure authentication using JWT tokens.
- **Comments:** Users can create, read, update, and delete comments on posts.
- **Posts:** Users can create, read, update, and delete posts.
- **Exception Handling:** Global exception handling is implemented to provide consistent error responses.
- **Database Interaction:** JPA repositories are used for interacting with the database.
- **Service Layer:** Service layer implementations handle business logic for comments and posts.

## Technologies Used

- Java
- Spring Boot
- Spring Security
- JPA/Hibernate
- JWT Authentication

## Project Structure

The project structure is organized into several packages:

- `config`: Contains the security configuration class.
- `controller`: Contains controllers for handling authentication, comments, and posts.
- `entity`: Contains entity classes for comments, posts, roles, and users.
- `exception`: Contains exception handling classes.
- `payload`: Contains DTOs for data transfer.
- `repository`: Contains JPA repositories for database interaction.
- `security`: Contains classes for custom user details service.
- `service`: Contains service interfaces and implementations for comments and posts.
- `resources`: Contains application properties file.

## Getting Started

To run the application, you need to have Java and Maven installed on your machine. Clone the repository, navigate to the project directory, and run the following command:


The application will start on port 8080 by default. You can access the API documentation at `http://localhost:8080/swagger-ui.html`.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request if you would like to contribute to this project.

## License

This project is licensed under the Manish kumar License - see the [LICENSE.md](LICENSE.md) file for details.

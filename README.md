# ms-book-store-api

This app manages books, publishers and their author.


## Features
* User registration and login with JWT authentication
* Adding of books
* Querying of Books, Author and Publisher
* Search of book by ID and Keywords
* Password encryption using BCrypt
* Role-based authorization with Spring Security
* Customized access denied handling


## Techologies
* Spring Boot 3.0
* Spring Security
* JSON Web Tokens (JWT)
* BCrypt
* Maven
* Postgress DB

## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

> - JDK 8+
> - Maven 3+
> - Creaate a postgress DB

## To build and run the project, follow these steps:

Clone the repository: git clone https://github.com/
Navigate to the project directory: cd ms-crud-book-store
Build the project: mvn clean install

Run the project: mvn spring-boot:run
-> The application will be available at http://localhost:8000.

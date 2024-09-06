# Registration System

This project implements a registration system using Spring Boot and Thymeleaf. It includes two sign-up pages with different requirements and validations. The system demonstrates handling user registration, password encryption, and basic security configuration.

## Features

- **Sign-Up Page 1**
  - Fields: Name, Email ID, Mobile Number, Create Password, Confirm Password, Numerical Values (1-9)
  - Document Upload: Supports image formats, PDF, Word, Excel
  - Password encryption and data storage
  - Redirects to a confirmation page displaying the submitted information

- **Sign-Up Page 2**
  - Fields: Name, Email ID, Mobile Number, Create Password, Confirm Password, Numerical Values (1-4)
  - Displays a message indicating missing numerical values compared to Sign-Up Page 1
  - Document Upload: Supports image formats, PDF, Word, Excel
  - Password encryption and data storage
  - Redirects to a confirmation page displaying the submitted information

- **Login Page**
  - Authentication with username and password
  - Error messages for invalid credentials and logout success

## Technologies Used

- Spring Boot 3.2.9
- Thymeleaf
- Spring Security
- BCrypt for password encryption
- Spring Data JPA (for database operations)
- MySQL or PostgreSQL (database options)

## Getting Started

### Prerequisites

- Java 1.8 or higher
- Maven
- MySQL or PostgreSQL database (depending on your configuration)

### Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/sagar123patel/registration.git
   cd registration

# Education Management System

A RESTful API for managing students, courses, and enrollments built with Spring Boot 4.

## Tech Stack

- **Java 21**, Gradle
- **Spring Boot 4.0.7** — Web MVC, Data JPA, Validation
- **PostgreSQL**, Hibernate
- **MapStruct 1.6.3** — DTO mapping
- **SpringDoc OpenAPI 3.0.2** — Swagger UI at `/swagger-ui.html`
- **Lombok**

## Setup

1. Create a PostgreSQL database named `education_management_system`
2. Update credentials in `application.properties` if needed
3. Run: `./gradlew bootRun`

## API Endpoints

### Student — `/student`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/student` | Create a student |
| GET | `/student` | Get all students |
| GET | `/student/{studentId}` | Get student by `studentId` (e.g. `STU-1001`) |
| PUT | `/student/{studentId}` | Update student |
| DELETE | `/student/{studentId}` | Delete student |

### Course — `/courses`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/courses` | Create a course |
| GET | `/courses` | Get all courses |
| GET | `/courses/{id}` | Get course by numeric ID |
| GET | `/courses/code/{courseCode}` | Get course by code (e.g. `CSE-101`) |
| PUT | `/courses/{id}` | Update course |
| DELETE | `/courses/{id}` | Delete course |

### Enrollment — `/enrollments`

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/enrollments` | Enroll a student in a course |
| GET | `/enrollments` | Get all enrollments |
| GET | `/enrollments/{id}` | Get enrollment by ID |
| GET | `/students/{studentId}/courses` | Get courses enrolled by a student |

## Business Rules

- Student and course must exist before enrollment
- A student cannot enroll in the same course twice in the same semester
- A student can enroll in a maximum of 5 courses per semester
- Enrollment date is automatically set to the current date

## Error Handling

| Status | Scenario |
|--------|----------|
| 404 | Resource not found |
| 409 | Duplicate resource (student ID, email, course code, enrollment) |
| 400 | Validation errors |
| 500 | Unexpected errors |

## Project Structure

```
src/main/java/com/johurulislam/educationmanagementsystemwms/
├── config/        — OpenAPI config
├── controller/    — REST controllers
├── dto/           — Request/Response records
├── exception/     — Custom exceptions + @ControllerAdvice
├── mapper/        — MapStruct mappers
├── model/         — JPA entities
├── repo/          — Spring Data repositories
└── service/       — Business logic (interface + impl)
```

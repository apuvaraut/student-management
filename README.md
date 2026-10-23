# Student Management System (Spring Boot CRUD)

A basic CRUD web app: **Create, Read, Update, Delete** students.

**Tech:** Java 17, Spring Boot 3, Spring MVC, Spring Data JPA, Thymeleaf, H2 (in-memory DB), Maven.

## Project structure
```
student-management/
├── pom.xml
└── src/main/
    ├── java/com/example/studentmanagement/
    │   ├── StudentManagementApplication.java   <- main class
    │   ├── model/Student.java                  <- entity
    │   ├── repository/StudentRepository.java   <- DB access
    │   ├── service/StudentService.java         <- business logic
    │   └── controller/StudentController.java   <- web routes
    └── resources/
        ├── application.properties
        └── templates/
            ├── students.html                   <- list page
            └── student-form.html               <- add/edit page
```

## Run
```
mvn spring-boot:run
```
Then open http://localhost:8080

H2 console (optional): http://localhost:8080/h2-console
JDBC URL: `jdbc:h2:mem:studentdb`, user: `sa`, password: empty.

## Routes
| Method | URL                      | Action            |
|--------|--------------------------|-------------------|
| GET    | /students                | List all students |
| GET    | /students/new            | Add form          |
| POST   | /students/save           | Create / update   |
| GET    | /students/edit/{id}      | Edit form         |
| POST   | /students/delete/{id}    | Delete            |

## Notes
- Data is in memory, so it resets on restart. To persist, switch to MySQL
  by changing the datasource settings in `application.properties`
  and adding the MySQL driver to `pom.xml`.

# Customer CRUD operations
## Requirements:
- Java ( jdk 1.8+)
- Maven 3.0+
- Spring Boot(2.6.3)
- Database(postgreSQL)
- Database Drivers
- IDE( IntelliJ or Eclipse)
- Postman (To test application)
## Features
- Create `POST` `http://localhost:8080/api/customers`
- Update `PUT` `http://localhost:8080/api/customers`
- Get `GET` `http://localhost:8080/api/customers`
- Get `GET` `http://localhost:8080/api/customers/{id}`
- Search `GET` `http://localhost:8080/api/_search/customers`
- Delete `DELETE` `http://localhost:8080/api/customers/{id}`
## Dependency added
- spring web
- spring data jpa
- bean validation
- postgresql

## Steps to create Application
- Create project using [Spring Initializer](https://start.spring.io/)

- Select `maven`

- Select `spring boot version`

- Select `java version`

- Project metadata
  ```
  group(com.sunglowsys)
  artifact(customer-crud-operation)
  package name(com.sunglowsys)
  ```

- Select Packaging `jar`

- Add dependencies `Spring Web`, `Spring Data JPA`, `PostgreSQL Driver`, `Bean Validation`

- Click on `Generate`

- Extract the generated zip file

- Import application in IntelliJ or Eclipse

- Implement CRUD Operations

## How to run application
- Open terminal and go inside application directory(customer-crud-operation)
- Run command `mvn`

## Steps to Test application (Postman)

###  Create API
- Method `POST`
- URL `http://localhost:8080/api/customers`
- JSON Body
  ```
  {
      "id": null,
      "firstName" : "John",
      "lastName" : "Smith",
      "email" : "john.smith@gmail.com",
      "mobile" : "99986233",
      "gender" : "Male"
  }
  ```
###  Update API
  - Method `PUT`
  - URL `http://localhost:8080/api/customers`
  - JSON Body
    ```
    {
        "id": 1,
        "firstName": "John",
        "lastName": "Smith",
        "email": "john.smith@gmail.com",
        "mobile": "9876543212",
        "gender": "Male"
    }
    ```
###  Get All API

- Method `GET`
- URL `http://localhost:8080/api/customers?page=0&size=10`


###  Get All API
- Method `GET`
- URL `http://localhost:8080/api/customers?page=0&size=10`

###  Search API
- Method `GET`
- URL `http://localhost:8080/api/_search/customers?searchText=joh`

###  Delete API
- Method `DELETE`
- URL `http://localhost:8080/api/customers/1`


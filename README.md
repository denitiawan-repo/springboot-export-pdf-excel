# Learn export data to excel and pdf on springboot

### Introduction
On this repo we will learn how to export data to excel and pdf on Springboot Project.

If you want read the full articles all about this repo,
you can see on this [article](https://medium.com/@denitiawan/create-rest-api-for-export-data-to-excel-and-pdf-using-springboot-38a2ee6c73a0)

### Requirements
- Maven 3+
- Java 8+
- IDE Intelij
- browser (example chrome)

### Dependency
- Lombok
- poi-ooxml
- openpdf
- Spring Data JPA

### APis
| Method | URL APIs                                 | Description              | Browser  |
|--------|------------------------------------------|--------------------------|----------|
| GET    | localhost:8181/v1/report/user/pdf/all    | Download user list PDF   | CHROME   |
| GET    | localhost:8181/v1/report/user/excel/all  | Download user list Excel | CHROME   |






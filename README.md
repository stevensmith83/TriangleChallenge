# Code Tradeshift - Triangle challenge

**Target:** Write a program that will determine the type of a triangle. It should take the lengths of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene.

This is a Spring Boot project with Swagger. The simple API take the lengths of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene (or not a triangle). It handles integer values, in case of type mismatch, it returns bad request (400).

### Structure:
- **main concept:** create a flexible, reusable, readable structure with clean code
- base package for the application and constants
- endpoint definitions -> controller package
- logics -> service package
- configurations -> config package

### Tests:
- use JUnit
- test endpoint with MockMvc
- endpoint tests cover the calls with bad parameters
- service unit tests cover the calls with good parameters

### Logics:
- **eqilateral:** all sides are equal and it is a triangle
- **isosceles:** two sides are equal and it is a triangle
- **scalene:** all sides are different and it is a triangle
- **it is a triangle:** sum of each two sides is greater than the third side

### Usage:
- build and run (gradle-wrapper)
- **Swagger:** localhost:8080/swagger-ui.html
- **Curl:** curl -X GET --header 'Accept: text/plain' 'http://localhost:8080/triangle/type?a=1&b=1&c=1'
- **Request URL:** http://localhost:8080/triangle/type?a=1&b=1&c=1
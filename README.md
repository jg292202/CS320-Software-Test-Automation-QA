# Contact Service | Software Test Automation

**Java • JUnit 5 • Parameterized Testing • Input Validation • Software Quality Assurance**

Java contact-management application developed to demonstrate automated unit testing, requirements validation, and quality-focused software development.

The project separates the contact domain model from service-layer operations and uses JUnit 5 tests to verify expected behavior, validation rules, boundary conditions, and failure cases.

## Project Structure

- `Contact.java` - Contact domain model and field validation
- `ContactService.java` - Contact creation, retrieval, update, and deletion operations
- `ContactTest.java` - Unit and parameterized tests for the Contact model
- `ContactServiceTest.java` - Unit tests for ContactService behavior

## Test Coverage

### Contact Model

Automated tests verify:

- Valid contact creation
- Required-field validation
- Null input handling
- Contact ID length constraints
- Contact ID immutability
- First and last name length constraints
- Phone-number length and numeric-format validation
- Address length constraints
- Maximum valid field lengths
- Successful setter operations
- Invalid setter input

Parameterized JUnit tests are used to validate multiple invalid contact ID conditions with a shared test implementation.

### Contact Service

Service tests verify:

- Successful contact addition
- Duplicate contact ID rejection
- Contact deletion
- Full contact updates
- Updates to individual contact fields
- Rejection of updates for nonexistent contacts
- Validation of invalid data during updates

## Engineering Approach

The project reinforced an important principle in my software-development approach: requirements are more useful when they can be translated into specific, repeatable tests.

Rather than testing only successful behavior, the test suite exercises boundary conditions, invalid inputs, duplicate data, nonexistent records, and expected failure paths.

This approach has carried into my later backend work, where I use automated tests and API validation to verify authentication, authorization, CRUD behavior, and error handling.

## Design & Limitations

This is a focused academic test-automation project rather than a production contact-management application.

The implementation intentionally keeps persistence and application architecture simple so the primary focus remains on requirements validation and automated testing.

If I expanded the application today, I would add:

- A persistence layer rather than maintaining contact data only for the application session
- Additional service-level validation and error handling
- Broader automated test coverage for edge and failure conditions
- Integration testing between application layers
- Automated build and test execution through CI

The original project is preserved substantially as completed so the repository accurately represents the testing concepts and Java development skills demonstrated during the course.

## Technologies & Concepts

- Java
- JUnit 5
- Parameterized Testing
- Unit Testing
- Object-Oriented Programming
- Input Validation
- Boundary Testing
- Exception Testing
- CRUD Operations
- Software Test Automation
- Software Quality Assurance

## Repository Contents

- `Contact.java` - Contact model and validation logic
- `ContactService.java` - Contact-management service
- `ContactTest.java` - Model validation, boundary, and parameterized tests
- `ContactServiceTest.java` - Service behavior and failure-path tests

## Academic Context

Completed as part of **CS 320: Software Test Automation & QA** coursework at Southern New Hampshire University.

This repository is presented as a portfolio artifact demonstrating Java development, automated unit testing, requirements validation, and quality-focused software engineering.

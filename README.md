# Project Name: Star Wars API Testing

## Overview
This project is designed to demonstrate API testing using the RestAssured library in Java. It focuses on interacting with the Star Wars API (SWAPI) to perform various tests, including serialization of responses into Java objects and handling different API testing scenarios. The project covers tests for finding entities like the oldest person based on the `birth_year` and identifying films with specific characteristics from the Star Wars universe.

## Features
- **Serialization and Deserialization**: Converting JSON responses from SWAPI into Java objects and vice versa.
- **API Testing**: Uses RestAssured to make API calls and assert conditions based on the responses.
- **Complex Test Scenarios**: Includes tests for edge cases and complex scenarios like finding the oldest person or the film with the fewest planets.

## Prerequisites
- Java 8 or higher
- Gradle

## Dependencies
- **RestAssured**: For making API calls and asserting conditions on the responses.
- **JUnit**: For writing and running tests.
- **Lombok**: For annotations

## Setup and Running Tests
1. **Clone the Repository**
   ```bash```
2. **Run the tests**
   ```./gradlew test```

## Example tests:
- **Finding the Oldest Person**: Tests the logic to parse the birth_year and determine the oldest person from a list of characters.
- **Film with Most Planets**: Tests the functionality to find a film with the fewest planets featured, utilizing serialized data.
- **Verify Json Schema**: Verifies the response json schema.

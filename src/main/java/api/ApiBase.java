package api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class ApiBase {
    protected static final String BASE_URL = "https://swapi.dev/api/";

    protected RequestSpecification given() {
        return RestAssured.given().baseUri(BASE_URL);
    }
}
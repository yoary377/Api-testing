package test_api;

import api.PeopleApi;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class JsonTest {

    private final PeopleApi peopleApi = new PeopleApi();

    @Test
    public void jsonSchemaTest() {
        Response response = peopleApi.searchPeopleJson();
        response.then().
                assertThat().
                body(JsonSchemaValidator.matchesJsonSchemaInClasspath("people_schema.json"));
    }
}

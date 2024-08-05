package api;


import api.responses.PeopleSearchResponse;
import api.responses.Person;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PeopleApi extends ApiBase {

    public PeopleSearchResponse searchPersonByName(String name) {
        return given()
                .param("search", name)
                .get("people/")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(PeopleSearchResponse.class);
    }

    public Response searchPeopleJson() {
        return given()
                .get("people/")
                .then()
                .assertThat()
                .statusCode(200)
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
    }

    public Person getOldestCharacter() {
        List<Person> allCharacters = new ArrayList<>();
        String nextUrl = "people/";
        int numOfRequests = 0;

        while (nextUrl != null) {
            Response response = given()
                    .baseUri(BASE_URL)
                    .when()
                    .get(nextUrl)
                    .then()
                    .extract()
                    .response();

            List<Person> people = response.jsonPath().getList("results", Person.class);
            allCharacters.addAll(people);
            numOfRequests++;
            nextUrl = response.jsonPath().getString("next");
        }
        System.out.println("Number of requests: " + numOfRequests);

        Person oldest = allCharacters.stream()
                .max(Comparator.comparingDouble(Person::getBirthYearValue))
                .orElse(null);

        return oldest;
    }
}

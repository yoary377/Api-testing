package test_api;

import api.FilmsApi;
import api.PeopleApi;
import api.responses.PeopleSearchResponse;
import api.responses.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PeopleTests {

    private final PeopleApi peopleApi = new PeopleApi();
    private final FilmsApi filmsApi = new FilmsApi();

    @Test
    public void testSearchPersonByName() {

        String name = "Vader";
        PeopleSearchResponse peopleSearchResponse = peopleApi.searchPersonByName(name);
        Person person = peopleSearchResponse.getResults().get(0);
        assertThat(peopleSearchResponse.getResults().size(), equalTo(1));
        assertThat(person.getName(), equalTo("Darth Vader"));

    }

    @Test
    public void testSearchFewestPlanetsFilm() {
        String name = "Vader";
        PeopleSearchResponse peopleSearchResponse = peopleApi.searchPersonByName(name);
        Person person = peopleSearchResponse.getResults().get(0);

        List<String> films = person.getFilms();
        String starship = person.getStarships().get(0);

        String filmWithFewestPlanets = filmsApi.findFilmWithFewestPlanets(films);

        assertThat(filmWithFewestPlanets, notNullValue());

        assertThat(starship,
                in(filmsApi.searchFilm(filmWithFewestPlanets).getStarships()));

    }

    @Test
    public void getOldest() {
        Person oldest = peopleApi.getOldestCharacter();
        if (oldest != null) {
            System.out.println("The oldest character is " + oldest.getName() + " born in " + oldest.getBirth_year());
        } else {
            System.out.println("No characters found or error occurred.");
        }
    }
}

package api;

import api.responses.FilmResponse;

import java.util.List;

public class FilmsApi extends ApiBase {
    public FilmResponse searchFilm(String filmUrl) {
        return given()
                .get(String.format(filmUrl))
                .then()
                .assertThat()
                .statusCode(200)
                .extract().as(FilmResponse.class);
    }

    public String findFilmWithFewestPlanets(List<String> filmUrls) {
        String filmWithFewestPlanets = null;
        int fewestPlanetCount = Integer.MAX_VALUE;  // Initialize to maximum possible integer value

        for (String filmUrl : filmUrls) {
            FilmResponse filmResponse = searchFilm(filmUrl);
            List<String> planets = filmResponse.getPlanets();
            int planetCount = planets.size();

            if (planetCount < fewestPlanetCount) {
                fewestPlanetCount = planetCount;
                filmWithFewestPlanets = filmUrl;
            }
        }
        System.out.println("Film with the fewest planets: " + filmWithFewestPlanets + " (Planets: " + fewestPlanetCount + ")");
        return filmWithFewestPlanets;
    }
}

package api.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Person {


    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;
    private String created;
    private String edited;
    private String url;

    public double getBirthYearValue() {
        if (birth_year != null && birth_year.endsWith("BBY")) {
            return Double.parseDouble(birth_year.replace("BBY", "").trim());
        }
        return Double.MIN_VALUE; // Return a small value for unknown or non-BBY birth years
    }

}

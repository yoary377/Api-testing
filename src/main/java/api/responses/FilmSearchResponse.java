package api.responses;

import lombok.Data;

import java.util.List;

@Data
public class FilmSearchResponse {
    private int count;
    private String next;
    private String previous;
    private List<FilmResponse> results;
}

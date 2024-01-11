package org.example.service.omdb;

import org.example.exception.MovieSearchException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OmdbService {

    @Value("${omdb.url}")
    private String omdbUrl;

    @Value("${omdb.key}")
    private String omdbKey;

    public OmdbResponse findMovieByTitle(String title) {
        String fullUrl = String.format("%s/?apikey=%s&type=movie&t=%s", omdbUrl, omdbKey, title);

        return getOmdbResponse(fullUrl);
    }

    public OmdbResponse findMovieByImdbId(String imdbId) {
        String fullUrl = String.format("%s/?apikey=%s&type=movie&i=%s", omdbUrl, omdbKey, imdbId);

        return getOmdbResponse(fullUrl);
    }

    private OmdbResponse getOmdbResponse(String fullUrl) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OmdbResponse> response = restTemplate.getForEntity(fullUrl, OmdbResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new MovieSearchException("Failed to receive data from an external service.");
        }
    }
}

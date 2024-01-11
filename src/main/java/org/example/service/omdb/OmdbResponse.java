package org.example.service.omdb;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OmdbResponse {

    @JsonProperty("Actors")
    private String actors;

    @JsonProperty("Awards")
    private String awards;

    @JsonProperty("BoxOffice")
    private String boxOffice;

    @JsonProperty("Country")
    private String country;

    @JsonProperty("DVD")
    private String dvd;

    @JsonProperty("Director")
    private String director;

    @JsonProperty("Error")
    private String error;

    @JsonProperty("Genre")
    private String genre;

    @JsonProperty("Language")
    private String language;

    @JsonProperty("Metascore")
    private String metascore;

    @JsonProperty("Plot")
    private String plot;

    @JsonProperty("Poster")
    private String poster;

    @JsonProperty("Production")
    private String production;

    @JsonProperty("Rated")
    private String rated;

    @JsonProperty("Ratings")
    private List<Rating> ratings;

    @JsonProperty("Released")
    private String released;

    @JsonProperty("Response")
    private String response;

    @JsonProperty("Runtime")
    private String runtime;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Website")
    private String website;

    @JsonProperty("Writer")
    private String writer;

    @JsonProperty("Year")
    private String year;

    @JsonProperty("imdbID")
    private String imdbId;

    @JsonProperty("imdbRating")
    private String imdbRating;

    @JsonProperty("imdbVotes")
    private String imdbVotes;

    public String getActors() {
        return actors;
    }

    public String getAwards() {
        return awards;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public String getCountry() {
        return country;
    }

    public String getDvd() {
        return dvd;
    }

    public String getDirector() {
        return director;
    }

    public String getError() {
        return error;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getPlot() {
        return plot;
    }

    public String getPoster() {
        return poster;
    }

    public String getProduction() {
        return production;
    }

    public String getRated() {
        return rated;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public String getReleased() {
        return released;
    }

    public String getResponse() {
        return response;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getWebsite() {
        return website;
    }

    public String getWriter() {
        return writer;
    }

    public String getYear() {
        return year;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public static class Rating {

        @JsonProperty("Source")
        private String source;

        @JsonProperty("Value")
        private String value;
    }
}

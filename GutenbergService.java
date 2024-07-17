package com.example.library.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
public class GutenbergService {
    private final RestTemplate restTemplate;

    public GutenbergService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GutenbergBook> searchBooks(String query) {
        URI uri = UriComponentsBuilder.fromUriString("http://gutendex.com/books")
                .queryParam("search", query)
                .build()
                .toUri();

        GutenbergResponse response = restTemplate.getForObject(uri, GutenbergResponse.class);
        return response != null ? Arrays.asList(response.getResults()) : List.of();
    }

    public static class GutenbergResponse {
        private GutenbergBook[] results;

        public GutenbergBook[] getResults() {
            return results;
        }

        public void setResults(GutenbergBook[] results) {
            this.results = results;
        }
    }

    public static class GutenbergBook {
        private String title;
        private String[] authors;
        private String languages;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String[] getAuthors() {
            return authors;
        }

        public void setAuthors(String[] authors) {
            this.authors = authors;
        }

        public String getLanguages() {
            return languages;
        }

        public void setLanguages(String languages) {
            this.languages = languages;
        }
    }
}

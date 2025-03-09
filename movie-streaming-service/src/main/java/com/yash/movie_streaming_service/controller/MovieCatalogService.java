package com.yash.movie_streaming_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieCatalogService {

    public static final String CATALOG_SERVICE = "http://movie-catalog-service";

    @Autowired
    private RestTemplate restTemplate;

    public String getMoviePath(Long movieInfoId) {
        return restTemplate.getForEntity(CATALOG_SERVICE + "/movie-info/find-path/{movieInfoId}" , String.class , movieInfoId).getBody();
    }
}

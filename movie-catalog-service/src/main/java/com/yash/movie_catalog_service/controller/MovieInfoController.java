package com.yash.movie_catalog_service.controller;

import com.yash.movie_catalog_service.model.MovieInfo;
import com.yash.movie_catalog_service.model.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieInfoController {

    @Autowired
    private MovieInfoRepository repository;

    @PostMapping("/movie-info/save")
    public List<MovieInfo> saveAll(@RequestBody List<MovieInfo> movieInfoList) {
        return repository.saveAll(movieInfoList);
    }

    @GetMapping("/movie-info/list")
    public List<MovieInfo> findAll() {
        return repository.findAll();
    }

    @GetMapping("/movie-info/find-path/{movieInfoId}")
    public String findPathById(@PathVariable Long movieInfoId) {
        return repository.findById(movieInfoId)
                .map(MovieInfo::getPath)
                .orElse(null);
    }
}

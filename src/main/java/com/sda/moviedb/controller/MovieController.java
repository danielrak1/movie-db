package com.sda.moviedb.controller;

import com.sda.moviedb.domain.Movie;
import com.sda.moviedb.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("/")
    public String showMoviesList(Model model) {
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movies", movies);
        return "get-movies";
    }

    @GetMapping ("/add-movies")
    public String getAddMovies(Movie movie){
        return "add-movies";
    }

    @PostMapping ("/add-movies")
    public String addMovies(Model model, @Valid Movie movie, BindingResult result){
        if (result.hasErrors()){
            return "add-movies";
        }
        movieRepository.save(movie);
        return "redirect:/get-movies/";

    }
}

package fiap.com.br.moviedb.controller;

import fiap.com.br.moviedb.model.Movie;
import fiap.com.br.moviedb.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieRepository movieRepository;

    @GetMapping()
    public Page<Movie> list(Pageable pageable){
        return movieRepository.findAll(pageable);
    }

    @GetMapping("search")
    public Page<Movie> findByTitle(@RequestParam String title, Pageable pageable){
        return movieRepository.findByTitleContainingIgnoreCase(title, pageable);
    }

    @GetMapping(params = "genre")
    public Page<Movie> findByGenre(@RequestParam String genre, Pageable pageable){
        return movieRepository.findByGenreNameContainingIgnoreCase(genre,pageable);
    }

    @GetMapping(params = "director")
    public Page<Movie> findByDirector(@RequestParam String director, Pageable pageable){
        return movieRepository.findByDirectorNameContainingIgnoreCase(director, pageable);
    }

    @GetMapping(params = {"yearFrom", "yearTo"})
    public Page<Movie> findByYearInterval(@RequestParam Integer yearFrom, @RequestParam Integer yearTo, Pageable pageable){
        return movieRepository.findByReleaseYearBetween(yearFrom, yearTo, pageable);
    }

    @GetMapping(params = "rating")
    public Page<Movie> fingByRatingAbove(@RequestParam Double rating, Pageable pageable){
        return movieRepository.findByRatingGreaterThan(rating, pageable);
    }

    @GetMapping(params = {"genre", "yearFrom"})
    public Page<Movie> fingByGenreAndYear(@RequestParam String genre, @RequestParam Integer yearFrom,Pageable pageable){
        return movieRepository.findByGenreNameContainingIgnoreCaseAndReleaseYearGreaterThan(genre, yearFrom, pageable);
    }

    @GetMapping("director/{directorId}/top")
    public Page<Movie> findByDirectorAndRatingAbove(@PathVariable Long directorId, @RequestParam(name = "ratingAbove") Double rating, Pageable pageable ){
        return movieRepository.findByDirectorIdAndRatingGreaterThan(directorId, rating, pageable);
    }

}

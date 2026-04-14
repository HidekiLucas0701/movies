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
    public Page<Movie> getMovieByTitle(@RequestParam String title, Pageable pageable){
        return movieRepository.findByTitleContainingIgnoreCase(title, pageable);
    }
}

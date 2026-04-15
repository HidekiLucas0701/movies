package fiap.com.br.moviedb.repository;

import fiap.com.br.moviedb.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Page<Movie> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    Page<Movie> findByGenreNameContainingIgnoreCase(String genre, Pageable pageable);

    Page<Movie> findByDirectorNameContainingIgnoreCase(String director, Pageable pageable);

    Page<Movie> findByReleaseYearBetween(Integer yearFrom, Integer yearTo, Pageable pageable);

    Page<Movie> findByRatingGreaterThan(Double rating, Pageable pageable);

    Page<Movie> findByGenreNameContainingIgnoreCaseAndReleaseYearGreaterThan(String genre, Integer yearFrom, Pageable pageable);

    Page<Movie> findByDirectorIdAndRatingGreaterThan(Long directorId, Double rating, Pageable pageable);
}

package dev.Springdetivenc.movieapp.Controller;

import dev.Springdetivenc.movieapp.Model.Movie;
import dev.Springdetivenc.movieapp.Services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.AllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdb}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdb){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdb), HttpStatus.OK);
    }
}

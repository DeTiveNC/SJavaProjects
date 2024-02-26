package dev.Springdetivenc.movieapp.Services;

import dev.Springdetivenc.movieapp.Model.Movie;
import dev.Springdetivenc.movieapp.Repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> AllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdb){
        return movieRepository.findMovieByImdbId(imdb);
    }
}

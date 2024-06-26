package dev.rashi.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public  ResponseEntity<List<Movie>>allMovies(){
        return new ResponseEntity<List<Movie>>(movieService.AllMovies(),HttpStatus.OK);
    }

    @GetMapping("/{imdbId}") //whatever we are getting by /id, we want to convert it to ObjectId id
    public ResponseEntity<Optional<Movie>>getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.getSingleMovie(imdbId),HttpStatus.OK);
    }
}

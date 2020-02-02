package sujan.smiles.ratingdataservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sujan.smiles.ratingdataservice.model.Rating;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("ratings")
public class RatingsResource {

    @RequestMapping("{movieId}")
    public Rating getRatingByMovieId(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("users/{userId}")
    public List<Rating> getRatingByUserId(@PathVariable("userId") String userId) {

        List<Rating> ratingList = Arrays.asList(
                new Rating("m1", 4),
                new Rating("m2", 3),
                new Rating("m3", 4)
        );

        return ratingList;
    }

}

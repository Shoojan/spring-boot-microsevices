package sujan.smiles.moviecatalogservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import sujan.smiles.moviecatalogservice.model.CatalogItem;
import sujan.smiles.moviecatalogservice.model.Movie;
import sujan.smiles.moviecatalogservice.model.Rating;
import sujan.smiles.moviecatalogservice.model.UserRating;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("catalog")
public class MovieCatalogResource {

    private final RestTemplate restTemplate;

    /*
     * Can use WebClient instead of RestTemplate
     */
//    private final WebClient.Builder webClientBuilder;

    @Autowired
    public MovieCatalogResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("{userId}")
    public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId) {


        //get all rated movie Ids
        UserRating userRating = restTemplate.getForObject(
                "http://localhost:8083/ratings/users/" + userId,
                UserRating.class);


        return userRating.getUserRatings().stream()
                .map(rating -> {
                    //for each movie Id, call movie Info service and get details
                    Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);

                    //put them all together
                    return new CatalogItem(
                            rating.getMovieId(),
                            rating.getMovieId() + " " + movie.getName(),
                            rating.getRating());
                })
                .collect(Collectors.toList());


//        return ratings.stream()
//                .map(rating -> {
//
//                    Movie movie = webClientBuilder.build()
//                            .get()
//                            .uri("http://localhost:8082/movies/" + rating.getMovieId())
//                            .retrieve()
//                            .bodyToMono(Movie.class)
//                            .block();
//
//                    return new CatalogItem(
//                            movie.getName(),
//                            "desc of" + rating.getMovieId(),
//                            rating.getRating());
//
//                })
//                .collect(Collectors.toList());

    }

}

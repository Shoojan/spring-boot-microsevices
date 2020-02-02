package sujan.smiles.moviecatalogservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sujan.smiles.moviecatalogservice.model.CatalogItem;

import java.util.Collections;
import java.util.List;

@RestController()
@RequestMapping("catalog")
public class MovieCatalogResource {

    @GetMapping("{userId}")
    public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId) {

        //get all rated movie Ids


        //for each movie Id, call movie Info service and get details

        //put them all together
        return Collections.singletonList(
                new CatalogItem("Dark Water", "Real based movie", 4)
        );

    }

}

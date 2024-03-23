package ecom.mobile.app.controller;

import ecom.mobile.app.model.Favorite;
import ecom.mobile.app.service.serviceInterface.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/favorite/{userId}")
    public List<Favorite> fetchAllFavoriteByUserId(@PathVariable("userId") int id) {
        return favoriteService.fetchAllFavoriteByUserId(id);
    }

    @PostMapping("/favorite")
    public Favorite saveFavorite(@RequestBody Favorite favorite) {
        return favoriteService.saveFavorite(favorite);
    }

    @DeleteMapping("/favorite/{id}")
    public String deleteFavorite(@PathVariable("id") int id) {
        return favoriteService.deleteFavorite(id);
    }

}

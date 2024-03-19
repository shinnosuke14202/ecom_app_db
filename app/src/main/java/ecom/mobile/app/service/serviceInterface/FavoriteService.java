package ecom.mobile.app.service.serviceInterface;

import ecom.mobile.app.model.Favorite;

import java.util.List;

public interface FavoriteService {
    List<Favorite> fetchAllFavoriteByUserId(int id);


    Favorite saveFavorite(Favorite favorite);

    String deleteFavorite(int id);

}

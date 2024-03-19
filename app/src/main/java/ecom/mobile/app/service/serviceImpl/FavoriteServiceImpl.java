package ecom.mobile.app.service.serviceImpl;

import ecom.mobile.app.model.Favorite;
import ecom.mobile.app.repository.FavoriteRepository;
import ecom.mobile.app.service.serviceInterface.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Override
    public List<Favorite> fetchAllFavoriteByUserId(int id) {
        return favoriteRepository.findAllByUserId(id);
    }

    @Override
    public Favorite saveFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }

    @Override
    public String deleteFavorite(int id) {
        favoriteRepository.deleteById(id);
        return "Favorite product with id = " + id + " deleted successfully";
    }

}
